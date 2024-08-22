package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configure the Spring Beans
@Configuration
public class HelloWorldConfiguration {

    // A Bean that will be managed by the spring context
    @Bean
    public String name() {
        return "Joe";
    }
}
