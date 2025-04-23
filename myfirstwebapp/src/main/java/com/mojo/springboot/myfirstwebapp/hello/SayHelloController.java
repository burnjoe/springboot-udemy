package com.mojo.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    
    // Returns a String response
    @RequestMapping("say-hello")
    // Return anything returned by this method as response body may it be string or object
    // Without @ResponseBody annotation Spring assumes that the method
    // is supposed to return a view name for rendering (which is not defined)
    @ResponseBody
    public String sayHello() {
        return "Hello! How are you doing?";
    }

    // Returns an HTML response
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

    // Returns an HTML response from JSP
    // This is handled by View Resolver configured in 'application.properties'
    // When /say-hello-jsp is requested it redirects client to sayHello.jsp
    // "say-hello-jsp" -> sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // Returning an HTML response from JSP does not need @ResponseBody
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        // This returns the jsp with the filename sayHello, this refers to sayHello.jsp
        // Please refer configuration in 'application.properties'
        return "sayHello";
    }
}
