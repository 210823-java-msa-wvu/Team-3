package dev.knapp.controllers;

import dev.knapp.beans.User;
import dev.knapp.payload.JWTLoginSuccessResponse;
import dev.knapp.payload.LoginRequest;
import dev.knapp.security.JwtTokenProvider;
import dev.knapp.services.MapValidationErrorService;
import dev.knapp.services.UserService;
import dev.knapp.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import javax.validation.Valid;

import static dev.knapp.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        //Validate Password match
        log.info("Getting User Attributes in register and checking password" );
        userValidator.validate(user, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null){
            log.error("Error Register in: {}", errorMap);
            return errorMap;
        }

        User newUser = userService.registerUser(user);


        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null){
            log.error("Error logging in: {}", errorMap);

            return errorMap;
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }

}
