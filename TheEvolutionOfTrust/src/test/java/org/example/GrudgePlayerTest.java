package org.example;

import org.example.players.GrudgePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrudgePlayerTest {

    @Test
    public void testGrudgePlayerInitialChoiceMustBeCooperate() {
        GrudgePlayer player = new GrudgePlayer();

        assertEquals(Choice.COOPERATE, player.playChoice());
    }

    @Test
    public void testWhenGrudgePlayerInvestThenHeWillCheat() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.invest();

        assertEquals(Choice.CHEAT, grudgePlayer.playChoice());
    }

    @Test
    public void testWhenGrudgePlayerGainHeWillNeverCheat() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();

        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());
    }

    @Test
    public void testGrudgePlayerAlwaysCooperateWhenHwIsGainingWhenHeInvestingThenHeWillCheat() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();
        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());

        grudgePlayer.invest();
        assertEquals(Choice.CHEAT, grudgePlayer.playChoice());
    }

    @Test
    public void testGrudgePlayerWillAlwaysCheatIfHeGotCheatedOnce() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());

        grudgePlayer.invest();
        assertEquals(Choice.CHEAT, grudgePlayer.playChoice());

        grudgePlayer.invest();
        assertEquals(Choice.CHEAT, grudgePlayer.playChoice());
    }

    @Test
    public void testGrudgePlayerAlwaysCooperateIfHeWouldNotGotCheated() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();
        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());

        grudgePlayer.gain();
        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());

        grudgePlayer.gain();
        assertEquals(Choice.COOPERATE, grudgePlayer.playChoice());
    }
}