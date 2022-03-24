package sk.stuba.fei.uim.assignment1;

import sk.stuba.fei.uim.assignment1.actioncards.container.ActionCards;
import sk.stuba.fei.uim.assignment1.engine.InitPlayers;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;

public class DuckHunt extends ValidInput {




    public  DuckHunt(){

        System.out.println("Welcome to Duck Hunt!");


        InitPlayers initPlayers = new InitPlayers();


        Pond pond = new Pond(initPlayers.getPlayerCnt());


        ArrayList<Player> players = initPlayers.getPlayers();


        ActionCards actionCards = new ActionCards(pond,players);

        initPlayers.initHand(actionCards);




//        while (players.size() > 1){
            System.out.println(" Index\t\t\tReticle\t\t\t  Ducks\n");
            for(int i = 0; i < 6; i++){
                System.out.println("| " + (i+1) + "  \t\t\t" +
                                  (pond.accessAim().get(i) ? " Locked " : "Unlocked") + "\t\t\t" +
                                   pond.accessArena().get(i) + "  |");
            }
            System.out.println();
        //}


    }
}
