package com.mojo.rest.webservices.restful_web_services.helloworld;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Marks this class as a REST controller
// This class will automatically serialize returned objects to JSON
// In Spring MVC, this is a combination of @Controller and @ResponseBody
@RestController
public class HelloWorldController {
    
    // Maps HTTP GET requests to /hello-world to this method
    // The method returns a string, which will be the response body of the HTTP response
    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    // Maps HTTP GET requests to /hello-world to this method without using the RequestMapping annotation
    // @GetMapping(path = "/hello-world") or simply just:
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
