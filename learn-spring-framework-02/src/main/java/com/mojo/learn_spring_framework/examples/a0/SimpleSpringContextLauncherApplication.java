package com.mojo.learn_spring_framework.examples.a0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/*
 * Dependency Injection Types:
 * 1. Constructor-based - creating bean using constructor
 * 2. Setter-based - set by calling setter methods on your beans
 * 3. Field - injected using reflection
 * 
 * Note:
 * Spring team recommends the usage of Constructor-based injection
 * as dependencies are automatically set when object is created.
 */


@Component
class YourBusinessClass {

    // Field Injection
    @Autowired
    Dependency1 dependency1;
    
    Dependency2 dependency2;

    Dependency3 dependency3;
    
    // Constructor Injection (Can be implicit - without explicitly autowiring it with @Autowired)
    @Autowired
    public YourBusinessClass(Dependency3 dependency3) {
        this.dependency3 = dependency3;
    }

    // Setter Injection
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString() {
        return String.format("Using %s and %s and %s.", dependency1, dependency2, dependency3);
    }
}

@Component
class Dependency1 {}

@Component
class Dependency2 {}

@Component
class Dependency3 {}


@Configuration
// Specify base package where Spring would look for components (@Component, @Service, @Repository, @Controller, etc.)
// Without explicitly defining the base package, this means it will look for components on this package where this class resides
@ComponentScan
public class SimpleSpringContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
