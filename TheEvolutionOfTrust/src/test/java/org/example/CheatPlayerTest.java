package org.example;

import org.example.players.CheatPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheatPlayerTest {
    @Test
    public void expectsToCreateACheatPlayer() {
        assertDoesNotThrow(() -> new CheatPlayer());
    }

    @Test
    public void expectsToAlwaysGiveChoiceCheat() {
        Player player = new CheatPlayer();
        assertEquals(Choice.CHEAT, player.playChoice());
    }

}