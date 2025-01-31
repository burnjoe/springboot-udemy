package com.mojo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    // http://localhost:8080/ | method = GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        // Temporarily hardcoding the name
        model.addAttribute("name", "Mojo");
        return "welcome";
    }
}
