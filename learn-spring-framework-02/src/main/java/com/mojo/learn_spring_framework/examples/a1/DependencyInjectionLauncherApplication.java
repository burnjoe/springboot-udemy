package com.mojo.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Specify base package where Spring would look for components (@Component, @Service, @Repository, @Controller, etc.)
// Without explicitly defining the base package, this means it will look for components on this package where this class resides
@ComponentScan
public class DependencyInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        }
    }
}
