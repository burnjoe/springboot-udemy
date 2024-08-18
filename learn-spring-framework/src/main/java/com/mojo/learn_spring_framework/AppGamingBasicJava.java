package com.mojo.learn_spring_framework;

import com.mojo.learn_spring_framework.game.GameRunner;
import com.mojo.learn_spring_framework.game.MarioGame;

public class AppGamingBasicJava {
    
    public static void main(String[] args) {
    
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
        
        // Unable to pass the superContraGame to GameRunner() since it's tightly coupled to MarioGame`
        // var superContraGame = new SuperContraGame();
        // var gameRunner = new GameRunner(superContraGame);
        // gameRunner.run();
    }
}
