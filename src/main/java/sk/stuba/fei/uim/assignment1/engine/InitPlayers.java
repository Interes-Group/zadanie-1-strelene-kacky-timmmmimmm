package sk.stuba.fei.uim.assignment1.engine;

import sk.stuba.fei.uim.assignment1.actioncards.container.ActionCards;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;

public class InitPlayers extends ValidInput {


    private byte playerCnt;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();


    public InitPlayers(){
        getPlayerCnt();
        getPlayerNames();
        setPlayers();
    }


    public byte getPlayerCnt(){
        if(playerCnt == 0)
            playerCnt = playerCount();

        return playerCnt;
    }

    private void getPlayerNames(){
        for (int i = 0; i < playerCnt; i++) {
            System.out.print("Enter the name of player " + (i+1) + ": ");
            names.add(getName());
        }
    }

    private void setPlayers(){
        for (byte i = 1; i <= playerCnt; i++) {
            players.add(new Player(names.get(i-1),i));
        }
    }


    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void initHand(ActionCards actionCards){
        for (Player player : players) {
            player.setHand(actionCards.fillHand());
        }
    }


}
