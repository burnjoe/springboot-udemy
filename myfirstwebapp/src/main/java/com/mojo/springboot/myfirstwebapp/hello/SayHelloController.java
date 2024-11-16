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

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        // Direct String appending creates new objects (not efficient); StringBuilder is faster and memory-efficient.
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}
