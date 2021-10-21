package dev.knapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

    @Bean // So that it can be available to use
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
       return  new BCryptPasswordEncoder();
    }
}
