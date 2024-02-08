package org.example;

import org.example.players.CheatPlayer;
import org.example.players.CooperatePlayer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TournamentTest {
    @Test
    public void testCanNotStartTheTournamentWithLessThan5RoundsShouldThrowAnError(){
        Tournament tournament = new Tournament();

        assertThrows(IllegalArgumentException.class,()->{
            tournament.start(4);
        });
    }

    @Test
    public void testTournamentMustEnroll5OrMorePlayersShouldThrowAnError(){
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();

        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);

        assertThrows(IllegalArgumentException.class,()->{
            tournament.start(5);
        });

    }

    @Test
    public void testAllPlayersAreSame(){
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CheatPlayer();
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        tournament.start(5);
        assertTrue(tournament.allPlayersSame());
    }
    @Test
    public void testIfAllPlayerAreSameThenNoOneGainAndNoOneInvest(){
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CheatPlayer());
        Tournament tournament = spy(new Tournament());
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        tournament.start(5);

        verify(tournament,times(1)).allPlayersSame();
        verify(player1,times(0)).gain();
        verify(player1,times(0)).invest();
        verify(player2,times(0)).gain();
        verify(player2,times(0)).invest();
        verify(player3,times(0)).gain();
        verify(player3,times(0)).invest();
        verify(player4,times(0)).gain();
        verify(player4,times(0)).invest();
        verify(player5,times(0)).gain();
        verify(player5,times(0)).invest();
    }

    @Test
    public void testIf4PlayersAreCheat1PlayerIsCooperateThenCheatPlayersGain1TimesAndCooperatePlayerInvest4Times(){
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        tournament.start(1);

        verify(player1,times(1)).gain();
        verify(player1,times(0)).invest();
        verify(player2,times(1)).gain();
        verify(player2,times(0)).invest();
        verify(player3,times(1)).gain();
        verify(player3,times(0)).invest();
        verify(player4,times(1)).gain();
        verify(player4,times(0)).invest();
        verify(player5,times(0)).gain();
        verify(player5,times(4)).invest();
    }

    @Test
    public void testAbleToCloneTop5PlayerAndRemoverOtherPlayers() {
        Tournament tournament = spy(new Tournament());

        CheatPlayer player1 = new CheatPlayer();
        CheatPlayer player2 = new CheatPlayer();
        CheatPlayer player3 = new CheatPlayer();
        CheatPlayer player4 = new CheatPlayer();
        CheatPlayer player5 = new CheatPlayer();
        CooperatePlayer player6 = new CooperatePlayer();
        CooperatePlayer player7 = new CooperatePlayer();
        CooperatePlayer player8 = new CooperatePlayer();
        CooperatePlayer player9 = new CooperatePlayer();
        CooperatePlayer player10 = new CooperatePlayer();

        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);
        tournament.enroll(player6);
        tournament.enroll(player7);
        tournament.enroll(player8);
        tournament.enroll(player9);
        tournament.enroll(player10);

        List<Player> newList = tournament.start(2);

        assertEquals(10,newList.size());
    }
}
