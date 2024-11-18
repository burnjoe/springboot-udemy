package com.mojo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    // http://localhost:8080/login?name=[value]
    @RequestMapping("login")
    // ModelMap allows us to pass the value of name to view (jsp) - similar to how 'props' works in frontend frameworks
    // It holds the props or parameters to be passed to the view or jsp
    // To access name value in jsp: ${name}
    public String goToLogin(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "login";
    }
}
