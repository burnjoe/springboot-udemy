package com.mojo.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Dependency Injection Types:
 * 1. Constructor-based - creating bean using constructor
 * 2. Setter-based - set by calling setter methods on your beans
 * 3. Field - injected using reflection
 */

// Annotated it with @Component to let Spring creates the GameRunner for us
@Component
public class GameRunner {
    // This makes the code loosely coupled
    private GamingConsole game;

    // Constructor Injection
    // Use GamingConsole implementation which has qualifier: SuperContraGameQualifier
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
