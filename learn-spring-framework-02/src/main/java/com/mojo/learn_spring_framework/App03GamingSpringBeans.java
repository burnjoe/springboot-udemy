package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mojo.learn_spring_framework.game.GameRunner;
import com.mojo.learn_spring_framework.game.GamingConsole;

public class App03GamingSpringBeans {
    
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            
            // Calls the GamingConsole bean defined in GamingConfiguration
            context.getBean(GamingConsole.class).up();
            
            // Calls the GameRunner bean defined in GamingConfiguration
            context.getBean(GameRunner.class).run();
        }
    }
}
