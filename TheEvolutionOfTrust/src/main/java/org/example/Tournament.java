package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tournament {
    private List<Player> players;

    public Tournament() {
        this.players = new ArrayList<>();
    }

    public void enroll(Player player){
        this.players.add(player);
    }
    public List<Player> start(int numberOfRounds){
        if(this.players.size()<5){
            throw new IllegalArgumentException("Can not start the tournament with less than 5 players");
        }
        if(numberOfRounds<1){
            throw new IllegalArgumentException("Can not start the tournament with less than 5 rounds");
        }

        for(int i=0;i<numberOfRounds;i++){
            if(allPlayersSame()){
                break;
            }
            for(int j=0;j<players.size();j++){
                for(int k=j+1;k<players.size();k++){
                    TrustTransaction trustTransaction = new TrustTransaction(this.players.get(j),this.players.get(k));
                    trustTransaction.transact(1);
                }
            }
            cloneTop5Players();
            eliminateLast5Players();

        }
        return this.players;

    }

    private void cloneTop5Players(){
        players.sort(Comparator.comparing(Player::score).reversed());

        for (int i=0;i<=5;i++){
            players.add(players.get(i).clone());
        }
        System.out.println(players);
    }

    private void eliminateLast5Players(){
        players.sort(Comparator.comparing(Player::score));

        for (int i=0;i<players.size()-5;i++){
            players.remove(players.get(i));
        }
        System.out.println(players);
    }

    public Boolean allPlayersSame(){
        int count = 1;

        for(int i=1;i<players.size();i++){
            if(players.getFirst().getClass()==players.get(i).getClass()){
                count++;
            }
        }
        return count == players.size();
    }

}
