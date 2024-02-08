package org.example;

import org.example.players.CooperatePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CooperatePlayerTest {
    @Test
    public void expectsToCreateACooperatePlayer() {
        assertDoesNotThrow(() -> new CooperatePlayer());
    }

    @Test
    public void expectsToAlwaysGiveChoiceCheat() {
        Player player = new CooperatePlayer();
        assertEquals(Choice.COOPERATE, player.playChoice());
    }
}