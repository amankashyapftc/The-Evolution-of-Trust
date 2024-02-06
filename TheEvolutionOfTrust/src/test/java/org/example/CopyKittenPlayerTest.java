package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenPlayerTest {
    @Test
    public void testCopyCatFirstChoiceIsCheat() {
        CopyKittenPlayer player = new CopyKittenPlayer("Chunnu");

        assertEquals(Choice.COOPERATE, player.playChoice());
    }

    @Test
    public void copyKittenPlayerWhenGainAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("Chunnu");

        copyKittenPlayer.gain();

        assertEquals(Choice.COOPERATE, copyKittenPlayer.playChoice());
    }

    @Test
    public void copyKittenPlayerWhenGainAndInvestAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("Chunnu");

        copyKittenPlayer.invest();
        copyKittenPlayer.gain();

        assertEquals(Choice.COOPERATE, copyKittenPlayer.playChoice());
    }

}