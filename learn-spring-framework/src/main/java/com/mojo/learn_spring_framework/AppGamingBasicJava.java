package com.mojo.learn_spring_framework;

import com.mojo.learn_spring_framework.game.GameRunner;
import com.mojo.learn_spring_framework.game.MarioGame;
import com.mojo.learn_spring_framework.game.PacmanGame;
import com.mojo.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {
    
    public static void main(String[] args) {
    
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacmanGame = new PacmanGame();
        
        // Runs MarioGame
        var gameRunner1 = new GameRunner(marioGame);
        gameRunner1.run();
        
        // RunsSuperContraGame
        var gameRunner2 = new GameRunner(superContraGame);
        gameRunner2.run();
        
        // Runs PacmanGame
        var gameRunner3 = new GameRunner(pacmanGame);
        gameRunner3.run();
    }
}
