package com.mojo.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
// This annotation is used to store the name attribute in the session
@SessionAttributes("name")
public class WelcomeController {

    // http://localhost:8080/ | method = GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        model.addAttribute("name", getLoggedInUsername());
        return "welcome";
    }

    // Gets the logged in username
    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return authentication.getName();
    }
}
