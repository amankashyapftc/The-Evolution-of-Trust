package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheatPlayerTest {
    @Test
    public void expectsToCreateACheatPlayer() {
        assertDoesNotThrow(() -> new CheatPlayer("Aman"));
    }

    @Test
    public void expectsToAlwaysGiveChoiceCheat() {
        Player player = new CheatPlayer("Chunnu");
        assertEquals(Choice.CHEAT, player.playChoice());
    }

}