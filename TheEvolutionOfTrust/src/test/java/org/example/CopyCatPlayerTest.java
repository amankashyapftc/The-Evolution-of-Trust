package org.example;

import org.example.players.CopyCatPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyCatPlayerTest {
    @Test
    public void testCopyCatFirstChoiceIsCheat() {
        CopyCatPlayer player = new CopyCatPlayer();

        assertEquals(Choice.CHEAT, player.playChoice());
    }
    @Test
    public void copycatPlayerWhenGainAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.gain();

        assertEquals(Choice.COOPERATE, copyCatPlayer.playChoice());
    }

    @Test
    public void copycatPlayerWhenInvestAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.invest();

        assertEquals(Choice.CHEAT, copyCatPlayer.playChoice());
    }

    @Test
    public void copycatPlayerWhenInvestAndGainAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.gain();
        copyCatPlayer.invest();

        assertEquals(Choice.COOPERATE, copyCatPlayer.playChoice());
    }

}