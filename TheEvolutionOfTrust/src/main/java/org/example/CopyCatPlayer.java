package org.example;

public class CopyCatPlayer implements Player{
    private boolean isGainedInPreviousRound = false;
    private String name;

    public CopyCatPlayer(String name){
        this.name = name;
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
    }
}
