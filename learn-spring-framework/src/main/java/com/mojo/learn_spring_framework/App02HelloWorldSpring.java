package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    
    public static void main(String[] args) {
        // 1: Launch a Spring Context   
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2: Configure the things that we want Spring to manage:
        // HelloWorldConfiguration - @Configuration
        // name - @Bean

        // 3: Retrieving Beans managed by Spring Context
        // Get bean by name
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        
        // Get bean with custom bean name
        System.out.println(context.getBean("myAddress"));
        
        // Get bean by type
        // It only expects to return single bean and not multiple bean with the same type
        System.out.println(context.getBean(Address.class));
    }
}
