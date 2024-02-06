package org.example.players;

import org.example.Choice;
import org.example.Player;

public class CopyKittenPlayer implements Player {
    private boolean isGainedInPreviousRound = true;

    private String name;

    public CopyKittenPlayer(String name){
        this.name = name;
    }
    @Override
    public Choice playChoice() {
        Choice choice = Choice.CHEAT;
        if (isGainedInPreviousRound) {
            choice = choice.COOPERATE;
        }
        isGainedInPreviousRound = false;
        return choice;
    }

    @Override
    public void gain() {
        this.isGainedInPreviousRound = true;
    }
}
