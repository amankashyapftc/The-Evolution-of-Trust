package org.example;

import org.example.players.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TrustTransactionTest {
    @Test
    public void expectsToCreateTransactionRulesObject(){
        CooperatePlayer player1 = new CooperatePlayer();
        CooperatePlayer player2 = new CooperatePlayer();
        assertDoesNotThrow(() -> new TrustTransaction(player1,player2));
    }

    @Test
    public void testIfBothPlayerAreCooperatePlayerThenBothScore2Points(){

        CooperatePlayer player1 = new CooperatePlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(2,trustTransaction.scoreCard.playerOneScore());
        assertEquals(2,trustTransaction.scoreCard.playerTwoScore());
    }


    @Test
    public void testIfBothPlayerAreCheatPlayerThenBothScore0Points(){
        CheatPlayer player1 = new CheatPlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(0,trustTransaction.scoreCard.playerOneScore());
        assertEquals(0,trustTransaction.scoreCard.playerTwoScore());
    }

    @Test
    public void testIfPlayer1IsCooperatePlayerAndPlayer2IsCheatPlayerThenPlayerOneScoreMinus1AndPlayer2Score3Points(){
        CooperatePlayer player1 = new CooperatePlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(-1,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }


    @Test
    public void testIfPlayer1IsCheatPlayerAndPlayer2IsCooperatePlayerThenPlayer1Score3AndPlayer2ScoreMinus1Points(){
        CheatPlayer player1 = new CheatPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(3,trustTransaction.scoreCard.playerOneScore());
        assertEquals(-1,trustTransaction.scoreCard.playerTwoScore());
    }


    @Test
    public void testIfBothPlayerAreCheatPlayerThenBothScore0PointsAfter5Rounds(){
        CheatPlayer player1 = new CheatPlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(5);

        assertEquals(0,trustTransaction.scoreCard.playerOneScore());
        assertEquals(0,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfBothPlayerAreCooperatePlayerThenBothScore0PointsAfter5Rounds(){
        CooperatePlayer player1 = new CooperatePlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(5);

        assertEquals(10,trustTransaction.scoreCard.playerOneScore());
        assertEquals(10,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsCooperatePlayerAndPlayer2IsCheatPlayerThenPlayer1ScoreWillBeMinus1AndPlayer2ScoreWillBe15After5Rounds(){
        CooperatePlayer player1 = new CooperatePlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(5);

        assertEquals(-5,trustTransaction.scoreCard.playerOneScore());
        assertEquals(15,trustTransaction.scoreCard.playerTwoScore());
    }


    //CopyCat
    @Test
    public void testIfPlayer1IsACopyCatPlayerAndPlayer2IsCooperatePlayerAfter1RoundPlayer1HasScore3AndPlayer2HasMinus1Score(){
        CopyCatPlayer player1 = new CopyCatPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(3,trustTransaction.scoreCard.playerOneScore());
        assertEquals(-1,trustTransaction.scoreCard.playerTwoScore());
    }

    @Test
    public void testIfPlayer1IsACopyCatPlayerAndPlayer2IsCooperatePlayerAfter2RoundPlayer1HasScore5AndPlayer2Has1Score(){
        CopyCatPlayer player1 = new CopyCatPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(2);

        assertEquals(5,trustTransaction.scoreCard.playerOneScore());
        assertEquals(1,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsACopyCatPlayerAndPlayer2IsCooperatePlayerAfter3RoundPlayer1HasScore7AndPlayer2Has3Score(){
        CopyCatPlayer player1 = new CopyCatPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(3);

        assertEquals(7,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }



    //CopyKitten
    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCooperatePlayerAfter1RoundPlayer1HasScore2AndPlayer2Has2Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(2,trustTransaction.scoreCard.playerOneScore());
        assertEquals(2,trustTransaction.scoreCard.playerTwoScore());
    }

    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCooperatePlayerAfter2RoundPlayer1HasScore4AndPlayer2Has4Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(2);

        assertEquals(4,trustTransaction.scoreCard.playerOneScore());
        assertEquals(4,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCooperatePlayerAfter3RoundPlayer1HasScore6AndPlayer2Has6Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(3);

        assertEquals(6,trustTransaction.scoreCard.playerOneScore());
        assertEquals(6,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCheatPlayerAfter1RoundPlayer1HasScoreMinus1AndPlayer2Has3Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(1);

        assertEquals(-1,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCheatPlayerAfter2RoundPlayer1HasScoreMinus1AndPlayer2Has3Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(2);

        assertEquals(-1,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }

    @Test
    public void testIfPlayer1IsACopyKittenPlayerAndPlayer2IsCheatPlayerAfter3RoundPlayer1HasScoreMinus1AndPlayer2Has3Score(){
        CopyKittenPlayer player1 = new CopyKittenPlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(3);

        assertEquals(-1,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }



    //GrudgePlayer
    @Test
    public void testIfPlayer1IsGrudgePlayerAndPlayer2IsCooperatePlayerAfter3RoundPlayer1HasScore6AndPlayer2Has6Score(){
        GrudgePlayer player1 = new GrudgePlayer();
        CooperatePlayer player2 = new CooperatePlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(3);

        assertEquals(6,trustTransaction.scoreCard.playerOneScore());
        assertEquals(6,trustTransaction.scoreCard.playerTwoScore());
    }
    @Test
    public void testIfPlayer1IsGrudgePlayerAndPlayer2IsCheatPlayerAfter3RoundPlayer1HasScore6AndPlayer2Has6Score(){
        GrudgePlayer player1 = new GrudgePlayer();
        CheatPlayer player2 = new CheatPlayer();

        TrustTransaction trustTransaction = new TrustTransaction(player1,player2);
        trustTransaction.transact(3);

        assertEquals(-1,trustTransaction.scoreCard.playerOneScore());
        assertEquals(3,trustTransaction.scoreCard.playerTwoScore());
    }


    //detective player
    @Test
    public void testDetectivePlayerFirstMoveWithCooperatePlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.transact(1);

        assertNull(transaction.winner());
        verify(detectivePlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void testDetectivePlayerSecondMoveWithCooperatePlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.transact(2);

        assertEquals(detectivePlayer, transaction.winner());
        verify(detectivePlayer, times(2)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(2)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void testDetectivePlayerTransactionWithCooperatePlayerAndNotGotCheated() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.transact(3);

        assertEquals(detectivePlayer, transaction.winner());
        verify(detectivePlayer, times(3)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(3)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void testDetectivePlayerFirstMoveWithCheatPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.transact(1);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void testDetectivePlayerSecondMoveWithCheatPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.transact(2);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void testDetectivePlayerTransactionWithCheatPlayerAndGotCheated() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.transact(3);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }
}