package org.example;

import org.example.players.DetectivePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectivePlayerTest {
    @Test
    public void testDetectivePlayerInitialMoveWillBeCooperate() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
    }

    @Test
    public void testDetectivePlayerSecondMoveMustBeCheat() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
    }

    @Test
    public void testAfterGainingDetectivePlayerAlways() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        detectivePlayer.gain();
        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
        detectivePlayer.gain();
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.gain();
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.gain();
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
    }

    @Test
    public void testAfterTwoMovesGetCheatedAndThanActLikeCopyCat() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        detectivePlayer.invest();

        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.invest();
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.gain();
        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
    }

}