package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    // A bean that will be managed by the spring context
    @Bean
    public String name() {
        return "Joe";
    }
}
