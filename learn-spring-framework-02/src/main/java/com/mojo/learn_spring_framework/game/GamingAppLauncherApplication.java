package com.mojo.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Specify base package where Spring would look for components (@Component, @Service, @Repository, @Controller, etc.)
@ComponentScan("com.mojo.learn_spring_framework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            // Autowires the GamingConsole (PacmanGame) which annotated by @Component
            context.getBean(GamingConsole.class).up();
            
            // Autowires the GameRunner annotated by @Component
            context.getBean(GameRunner.class).run();
        }
    }
}
