package com.mojo.learn_spring_framework.examples.f1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * Lifecycle Annotations:
 * 1. PostConstruct
 * 2. PreDestroy
 */

@Component
class SomeClass {

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependency are ready!");
    }

    // PostConstruct initializes the bean after dependencies are injected
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    // PreDestroy cleans up resources before the bean is destroyed
    @PreDestroy
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {
    
    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            
        }
    }
}
