package com.mojo.rest.webservices.restful_web_services.helloworld;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Return a new HelloWorldBean object
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    // Path Parameters
    // /users/{id}/todos/{id} => /users/1/todos/101
    // This method will be called when the URL matches /hello-world/path-variable/{name}
    // The {name} part of the URL is a path variable, which will be passed to the method as a parameter
    // The @PathVariable annotation tells Spring to bind the value of the path variable to the method parameter
    @GetMapping("hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s!", name));
    }
}
