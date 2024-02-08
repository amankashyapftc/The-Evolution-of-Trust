package org.example.players;

import org.example.Choice;
import org.example.Player;

public class GrudgePlayer extends Player {
    private boolean isGrudging = false;
    private boolean isInvestedInPreviousRound = false;

    @Override
    public Player clone() {
        return new GrudgePlayer();
    }

    @Override
    public Choice playChoice() {
        Choice choice = Choice.COOPERATE;
        if (isInvestedInPreviousRound && !this.isGrudging)
            this.isGrudging = true;
        if (isGrudging) {
            choice = Choice.CHEAT;
        }
        this.isInvestedInPreviousRound = false;
        return choice;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
        super.invest();
    }

    @Override
    public void gain() {
        this.isInvestedInPreviousRound = false;
        super.gain();
    }
}