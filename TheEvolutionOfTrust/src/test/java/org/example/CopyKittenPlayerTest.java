package org.example;

import org.example.players.CopyKittenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenPlayerTest {
    @Test
    public void testCopyCatFirstChoiceIsCheat() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Choice.COOPERATE, player.playChoice());
    }

    @Test
    public void copyKittenPlayerWhenGainAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();

        copyKittenPlayer.gain();

        assertEquals(Choice.COOPERATE, copyKittenPlayer.playChoice());
    }

    @Test
    public void copyKittenPlayerWhenGainAndInvestAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();

        copyKittenPlayer.invest();
        copyKittenPlayer.gain();

        assertEquals(Choice.COOPERATE, copyKittenPlayer.playChoice());
    }

}