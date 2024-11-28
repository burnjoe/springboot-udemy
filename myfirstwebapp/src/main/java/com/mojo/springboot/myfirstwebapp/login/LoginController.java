package com.mojo.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;


    // http://localhost:8080/login | method = GET
    // Without specifying the method = RequestMethod.GET both GET and POST (form submit) is handled by /login
    // Specifying it, only GET method will be handled by /login
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLogin() {
        return "login";
    }
    
    // http://localhost:8080/login | method = POST
    // Both name and password is fetched from the request payload
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        // Authentication
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials. Please Try Again.");
        return "login";
    }
}
