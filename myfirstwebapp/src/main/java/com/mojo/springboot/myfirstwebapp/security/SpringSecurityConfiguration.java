package com.mojo.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    
    // Typically, when we want to store username and password we make use of LDAP or Database
    // For now, we'll be working with In-memory

    // We create this Bean to store the user details so we don't have to use the generated password logged in console
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        // We use Builder to create a User (This one is deprecated)
        // User is a class that implements UserDetails from Spring Security
        // UserDetails userDetails = User.withDefaultPasswordEncoder()
        //         .username("mojo")
        //         .password("password")
        //         .roles("USER", "ADMIN")
        //         .build();

        // createNewUser allows us to create new users with the username and password entered by the user in the login form
        UserDetails userDetails1 = createNewUser("mojo", "password");
        UserDetails userDetails2 = createNewUser("admin", "password");
        UserDetails userDetails3 = createNewUser("user", "password");
        
        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
    }

    // This method is used to create a new user with the username and password entered by the user in the login form
    private UserDetails createNewUser(String username, String password) {
        // We use this lambda function to encode the password entered by the user in the login form
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        
        // We use Builder to create a User (This one is not deprecated)
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();

        return userDetails;
    }

    // This bean is used to encode the password entered by the user in the login form to check if it matches the encoded password stored in the UserDetails
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder is a class that implements PasswordEncoder from Spring Security
        return new BCryptPasswordEncoder();
    }
}
