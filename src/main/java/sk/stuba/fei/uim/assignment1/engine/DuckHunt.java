package sk.stuba.fei.uim.assignment1.engine;
import sk.stuba.fei.uim.assignment1.engine.cards.*;
import sk.stuba.fei.uim.assignment1.utility.CardsRemaining;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;


import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;








public class DuckHunt extends ValidInput {
    private Player[] players;
    private ArrayList<Card> cardPool = new ArrayList<>();
    private Map<Integer,ActionCard> actionCards = new HashMap<>();
    private CardsRemaining cardsRemaining = new CardsRemaining();


    public DuckHunt(){

        System.out.println("Welcome to Duck Hunt!");

        byte numOfPlayers = playerCount();

        fillActionCards();
        initDeck(numOfPlayers);




    }



    private void initDeck(byte playerCnt){


        players = new Player[playerCnt];

        for (byte i = 0; i < playerCnt; i++){
            players[i] = new Player(i);


            for (byte j = 0; j < 5; j++){
                players[i].setDucks(new Duck(i,j),j);
                cardPool.add(players[i].getDuck(j));
            }
        }

        for(byte i = 0; i < 5; i++){
            cardPool.add(new Water(i));
        }

        Collections.shuffle(cardPool);

        for(Player i : players){
            for(byte j = 0; j < 3; j++){
                i.setActionCards(new Action(random(), i.getID()));
            }


        }






    }



    private void fillActionCards(){

            actionCards.put(0,ActionCard.Aim);
            actionCards.put(1,ActionCard.Shoot);
            actionCards.put(2,ActionCard.WildBill);
            actionCards.put(3,ActionCard.DuckMarch);
            actionCards.put(4,ActionCard.TurboDuck);
            actionCards.put(5,ActionCard.Scatter);
            actionCards.put(6,ActionCard.DuckDance);

    }

    private ActionCard random(){
        int rand;

        rand = ThreadLocalRandom.current().nextInt(0,actionCards.size());

        if(cardsRemaining.cardRemaining(rand) == 0)     random();

        cardsRemaining.decrementValue(rand);


        return actionCards.get(rand);
    }

}
