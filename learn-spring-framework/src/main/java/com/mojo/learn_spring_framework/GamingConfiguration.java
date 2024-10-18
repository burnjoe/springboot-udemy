package com.mojo.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mojo.learn_spring_framework.game.GameRunner;
import com.mojo.learn_spring_framework.game.GamingConsole;
import com.mojo.learn_spring_framework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
    
    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    // Autowires the GamingConsole in the gameRunner's parameter
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
