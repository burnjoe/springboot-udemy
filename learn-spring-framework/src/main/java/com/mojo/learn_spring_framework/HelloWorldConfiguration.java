package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Person(String name, int age, Address address) {};
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
        return new Person("Lawrence", 22, new Address("Main Street", "London"));
    }

    // Approach 1: Calls bean method directly
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    
    // Approach 2: Fields are passed as argument in method's parameters automatically with Auto Wiring
    // Calls the beans with names: name, age, myAddress
    @Bean
    public Person person3Parameters(String name, int age, Address myAddress) {
        return new Person(name, age, myAddress);
    }

    // This creates a bean with custom bean name "myAddress" than "address"
    @Bean(name = "myAddress")
    public Address address() {
        return new Address("Halang", "Calamba");
    }
}
