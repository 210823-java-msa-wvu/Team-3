package dev.knapp.security;

import dev.knapp.beans.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static dev.knapp.security.SecurityConstants.EXPIRATION_TIME;
import static dev.knapp.security.SecurityConstants.SECRET;

@Component
public class JwtTokenProvider {
    //Generate token
    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();

        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);
        String userId = Integer.toString(user.getId());
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", (Integer.toString(user.getId())));
        claims.put("username", user.getUsername());
//        claims.put("fullName", user.getFullName());
        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
    //Validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired TWT Token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT Token");
        }catch (IllegalArgumentException ex) {
            System.out.println("JWT Claims String is empty");
        }
        return  false;
    }

    //Get user Id from Token
    public Integer getUserIdFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");
        return Integer.parseInt(id);

    }
}
