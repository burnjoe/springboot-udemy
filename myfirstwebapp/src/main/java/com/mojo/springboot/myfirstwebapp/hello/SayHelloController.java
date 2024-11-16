package com.mojo.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    
    @RequestMapping("say-hello")
    // Return anything returned by this method as response body may it be string or object
    // Without @ResponseBody annotation Spring assumes that the method
    // is supposed to return a view name for rendering (which is not defined)
    @ResponseBody
    public String sayHello() {
        return "Hello! How are you doing?";
    }
}
