package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Person(String name, int age) {};
record Address(String firstLine, String city) {};

// Configure the Spring Beans
@Configuration
public class HelloWorldConfiguration {

    // A Bean that will be managed by the spring context
    @Bean
    public String name() {
        return "Joe";
    }

    @Bean
    public int age() {
        return 22;
    }

    @Bean
    public Person person() {
        return new Person("Lawrence", 22);
    }

    @Bean
    public Address address() {
        return new Address("Halang", "Calamba");
    }
}
