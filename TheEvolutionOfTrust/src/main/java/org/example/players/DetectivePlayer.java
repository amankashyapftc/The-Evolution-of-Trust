package org.example.players;

import org.example.Choice;
import org.example.Player;

public class DetectivePlayer implements Player {

    private String name;
    private boolean isInvestedInPreviousRound = false;
    private boolean isGainedInPreviousRound = false;
    private int roundNumber = 0;
    private boolean isCopyCat = false;

    public DetectivePlayer(String name){
        this.name = name;
    }
    @Override
    public Choice playChoice() {
        this.roundNumber++;
        Choice choice = Choice.CHEAT;
        if (this.roundNumber == 1) {
            choice = Choice.COOPERATE;
        }
        else if (this.roundNumber == 2) {
            choice = Choice.CHEAT;
        }

        if (this.isInvestedInPreviousRound && !this.isCopyCat) {
            this.isCopyCat = true;
        }
        if (this.isCopyCat && this.roundNumber > 2) {
            if (isGainedInPreviousRound) {
                choice = Choice.COOPERATE;
            }
            isGainedInPreviousRound = false;
        }

        return choice;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
    }

    @Override
    public void gain() {
        this.isGainedInPreviousRound = true;
        if (this.isInvestedInPreviousRound) {
            this.isInvestedInPreviousRound = false;
        }
    }
}