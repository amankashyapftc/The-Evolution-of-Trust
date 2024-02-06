package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectivePlayerTest {
    @Test
    public void testDetectivePlayerInitialMoveWillBeCooperate() {
        DetectivePlayer detectivePlayer = new DetectivePlayer("Chunnu");
        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
    }

    @Test
    public void testDetectivePlayerSecondMoveMustBeCheat() {
        DetectivePlayer detectivePlayer = new DetectivePlayer("Chunnu");

        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
    }

    @Test
    public void testAfterGainingDetectivePlayerAlways() {
        DetectivePlayer detectivePlayer = new DetectivePlayer("Chunnu");

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
        DetectivePlayer detectivePlayer = new DetectivePlayer("Chunnu");

        detectivePlayer.invest();

        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.invest();
        assertEquals(Choice.CHEAT, detectivePlayer.playChoice());
        detectivePlayer.gain();
        assertEquals(Choice.COOPERATE, detectivePlayer.playChoice());
    }

}