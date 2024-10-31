package com.mojo.learn_spring_framework.excercise1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Spring Stereotype Annotations:
 * @Component - generic annotation applicable for any class (Base) 
 * 
 * Specializations of @Component:
 * 1. @Service
 * 2. @Controller
 * 3. @Repository
 */

@Configuration
@ComponentScan
public class AppLauncherApplication {
    
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppLauncherApplication.class)) {
            int max = context.getBean(BusinessCalculationService.class).findMax();
            System.out.println("\nMax: " + max);
        }
    }
}
