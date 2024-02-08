package org.example.players;

import org.example.Choice;
import org.example.Player;

public class CooperatePlayer extends Player {
    @Override
    public Player clone() {
        return new CooperatePlayer();
    }

    @Override
    public Choice playChoice() {
        return Choice.COOPERATE;
    }
}