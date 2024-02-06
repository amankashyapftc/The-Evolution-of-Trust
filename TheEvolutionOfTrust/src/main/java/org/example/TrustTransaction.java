package org.example;
public class TrustTransaction {

    private Player playerOne;

    private Player playerTwo;

    public ScoreCard scoreCard;


    public TrustTransaction(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scoreCard = new ScoreCard();
    }

    public void transact(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            Choice player1Choice = playerOne.playChoice();
            Choice player2Choice = playerTwo.playChoice();

            if (player1Choice == Choice.COOPERATE) {
                playerOne.invest();
                playerTwo.gain();
            }
            if (player2Choice == Choice.COOPERATE) {
                playerTwo.invest();
                playerOne.gain();
            }
            scoreCard.updateScores(player1Choice, player2Choice);
        }
    }

    public Player winner() {
        int player1Score = scoreCard.playerOneScore();
        int player2Score = scoreCard.playerTwoScore();
        if (player1Score > player2Score) {
            return playerOne;
        }
        else if (player2Score > player1Score) {
            return playerTwo;
        }
        return null;
    }
}