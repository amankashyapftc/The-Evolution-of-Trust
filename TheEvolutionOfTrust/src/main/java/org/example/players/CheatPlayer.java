package org.example.players;

import org.example.Choice;
import org.example.Player;

public class CheatPlayer extends Player {


    @Override
    public Choice playChoice() {
        return Choice.CHEAT;
    }

    @Override
    public Player clone() {
        return new CheatPlayer();
    }
}