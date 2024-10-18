package com.mojo.learn_spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    
    public static void main(String[] args) {
        // Replacing Try-catch-finally with Try-with-resources
        // 1: Launch a Spring Context
        try(var context = 
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            
            // 2: Configure the things that we want Spring to manage:
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3: Retrieving Beans managed by Spring Context
            // Get bean by name
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            
            // Get bean 'person2MethodCall' that calls other method/bean within its method body
            System.out.println(context.getBean("person2MethodCall"));
            
            // Get bean 'person3Parameters' that fills the parameters through Auto Wiring
            // Means that it passes the required arguments automatically with Spring's Auto Wiring 
            System.out.println(context.getBean("person3Parameters"));

            // Get bean with custom bean name
            System.out.println(context.getBean("myAddress"));
            
            // Get bean by type
            // It only expects to return single bean and not multiple bean with the same type
            System.out.println(context.getBean(Address.class));

            // List all the beans managed by the spring context
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        }
    }
}
