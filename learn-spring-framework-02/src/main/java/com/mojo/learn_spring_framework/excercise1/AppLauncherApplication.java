package com.mojo.learn_spring_framework.excercise1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
