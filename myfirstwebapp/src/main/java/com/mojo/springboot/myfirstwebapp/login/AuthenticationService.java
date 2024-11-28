package com.mojo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    // This authenticates username and password - hard coded
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("mojo");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUsername && isValidPassword;
    }
}
