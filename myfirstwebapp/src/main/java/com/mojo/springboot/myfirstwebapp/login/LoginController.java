package com.mojo.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    // Logger instance for logging messages specific to this class
    private Logger logger = LoggerFactory.getLogger(getClass());

    // http://localhost:8080/login?name=[value]
    @RequestMapping("login")
    // ModelMap allows us to pass the value of name to view (jsp) - similar to how 'props' works in frontend frameworks
    // It holds the props or parameters to be passed to the view or jsp
    // To access name value in jsp: ${name}
    public String goToLogin(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        // Logs to console at debug level (Configure in application.properties)
        logger.debug("Request param is {}", name);
        return "login";
    }
}
