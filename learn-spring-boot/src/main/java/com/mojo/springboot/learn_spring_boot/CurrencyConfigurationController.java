package com.mojo.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


// Indicates that this class handles HTTP requests and returns responses directly as JSON or XML
@RestController
public class CurrencyConfigurationController {
    
    @Autowired
    private CurrencyServiceConfiguration configuration;


    // Handles requests to "/courses"
    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return configuration;    
    }
}
