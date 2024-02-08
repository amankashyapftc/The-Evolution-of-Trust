package org.example;

import java.util.Random;

public class Player {
    private int score = 0;

    public Choice playChoice() {
        Random random = new Random();
        return random.nextInt(Choice.values().length) == 0 ? Choice.CHEAT: Choice.COOPERATE;
    }
    private void addScore(int score) {
        this.score += score;
    }

    public void gain() {
        this.addScore(3);
    }

    public void invest() {
        this.addScore(-1);
    }

    public int score() {
        return this.score;
    }

    public Player clone() {
        return new Player();
    }

}
