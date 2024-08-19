package com.mojo.learn_spring_framework;

import com.mojo.learn_spring_framework.game.GameRunner;
import com.mojo.learn_spring_framework.game.MarioGame;

public class App01GamingBasicJava {
    
    public static void main(String[] args) {
    
        //  Object Creation
        var game = new MarioGame();
        
        //  Object Creation + Wiring of Dependencies 
        // (Game is a Dependency of GameRunner)
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
