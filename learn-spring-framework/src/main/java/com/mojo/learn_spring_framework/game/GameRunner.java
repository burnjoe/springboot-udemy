package com.mojo.learn_spring_framework.game;

public class GameRunner {
    // This makes the code tightly coupled
    private MarioGame game;

    // This makes the code tightly coupled
    public GameRunner(MarioGame game) {
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
