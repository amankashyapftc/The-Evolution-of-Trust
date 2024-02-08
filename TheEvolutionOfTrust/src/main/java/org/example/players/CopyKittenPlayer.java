package org.example.players;

import org.example.Choice;
import org.example.Player;

public class CopyKittenPlayer extends Player {
    private boolean isGainedInPreviousRound = true;

    @Override
    public Player clone() {
        return new CopyKittenPlayer();
    }

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
    public void gain() {
        this.isGainedInPreviousRound = true;
        super.gain();
    }
}
