package dev.knapp.services;

import dev.knapp.beans.User;
import dev.knapp.exception.UsernameAlreadyExistsException;
import dev.knapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User registerUser(User newUser){
        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique(exception)
            newUser.setUsername(newUser.getUsername());
            //Make sure that password and confirmPassword match
            //we don't persist and show the confirmPassword
            newUser.setConfirmPassword("");

            return userRepo.save(newUser);

        }catch (Exception e){
            throw  new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists.");
        }
    }

}
