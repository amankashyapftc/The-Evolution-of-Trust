package org.example;

public class ScoreCard {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void updateScores(Choice playerOneMove, Choice playerTwoMove) {
        if (playerOneMove == Choice.CHEAT && playerTwoMove == Choice.COOPERATE) {
            this.playerOneScore += 3;
            this.playerTwoScore -= 1;
        }
        else if (playerOneMove == Choice.COOPERATE && playerTwoMove == Choice.CHEAT) {
            this.playerOneScore -= 1;
            this.playerTwoScore += 3;
        }
        else if (playerOneMove == Choice.COOPERATE && playerTwoMove == Choice.COOPERATE) {
            this.playerOneScore += 2;
            this.playerTwoScore += 2;
        }
    }

    public int playerOneScore() {
        return playerOneScore;
    }

    public int playerTwoScore() {
        return playerTwoScore;
    }
}