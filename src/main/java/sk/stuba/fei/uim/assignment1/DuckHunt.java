package sk.stuba.fei.uim.assignment1;

import sk.stuba.fei.uim.assignment1.actioncards.cards.Card;
import sk.stuba.fei.uim.assignment1.actioncards.container.ActionCards;
import sk.stuba.fei.uim.assignment1.engine.GameManager;
import sk.stuba.fei.uim.assignment1.engine.InitPlayers;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.FormattedOutput;

import java.util.ArrayList;
import java.util.Iterator;

public class DuckHunt extends FormattedOutput {



    public  DuckHunt(){

        System.out.println("Welcome to Duck Hunt!");


        InitPlayers initPlayers = new InitPlayers();


        if(initPlayers.getPlayerCnt() == -1){
            System.out.println("Game shutting down");
            return;
        }

        ArrayList<String> names = initPlayers.getPlayerNames();

        Pond pond = new Pond(initPlayers.getPlayerCnt());


        ArrayList<Player> players = initPlayers.getPlayers();


        ActionCards actionCards = new ActionCards(pond,players);

        initPlayers.initHand(actionCards);

        GameManager gameManager = new GameManager(pond,actionCards,players);


        byte currentPlayer = 0;
        int round = 0;

        while (players.size() > 1){

            if(currentPlayer >= players.size()){
                currentPlayer = 0;
                round ++;
            }


            drawPlayground(pond,players,currentPlayer,round,names);

            gameManager.useCard(currentPlayer);

            gameManager.checkPlayerStatus();

            currentPlayer++;
        }

        victoryMessage(players.get(0));
    }
}
