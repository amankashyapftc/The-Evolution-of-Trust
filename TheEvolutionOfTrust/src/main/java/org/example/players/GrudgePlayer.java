package org.example.players;

import org.example.Choice;
import org.example.Player;

public class GrudgePlayer implements Player {
    private boolean isGrudging = false;
    private String name;
    private boolean isInvestedInPreviousRound = false;

    public GrudgePlayer(String name){
        this.name = name;
    }
    @Override
    public Choice playChoice() {
        Choice choice = Choice.COOPERATE;
        if (isInvestedInPreviousRound && !this.isGrudging)
            this.isGrudging = true;
        if (isGrudging) {
            choice = Choice.CHEAT;
        }
        return choice;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
    }

    @Override
    public void gain() {
        if (this.isInvestedInPreviousRound) {
            this.isInvestedInPreviousRound = false;
        }
    }
}