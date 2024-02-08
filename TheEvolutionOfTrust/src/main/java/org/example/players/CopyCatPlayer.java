package org.example.players;

import org.example.Choice;
import org.example.Player;

public class CopyCatPlayer extends Player {
    private boolean isGainedInPreviousRound = false;


    @Override
    public Choice playChoice() {
        Choice choice = Choice.CHEAT;
        if (isGainedInPreviousRound) {
            choice = Choice.COOPERATE;
        }
        isGainedInPreviousRound = false;
        return choice;
    }

    @Override
    public Player clone() {
        return new CopyCatPlayer();
    }

    @Override
    public void gain() {
        this.isGainedInPreviousRound = true;
        super.gain();
    }
}
