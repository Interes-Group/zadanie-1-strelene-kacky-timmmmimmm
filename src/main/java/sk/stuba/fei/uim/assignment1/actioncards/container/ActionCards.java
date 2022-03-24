package sk.stuba.fei.uim.assignment1.actioncards.container;

import sk.stuba.fei.uim.assignment1.actioncards.cards.*;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;

import java.util.ArrayList;
import java.util.Collections;

public class ActionCards {
    
    ArrayList<Card> actionCards = new ArrayList<>();
    
    
    public ActionCards(Pond pond, ArrayList<Player> players){

        for (int i = 0; i < 12; i++) {
            actionCards.add(new Shoot(pond,players));
        }

        for (int i = 0; i < 10; i++) {
            actionCards.add(new Aim(pond));
        }

        for (int i = 0; i < 6; i++) {
            actionCards.add(new DuckMarch(pond));
        }

        for (int i = 0; i < 2; i++) {
            actionCards.add(new WildBill(pond,players));
            actionCards.add(new Scatter(pond));
        }

        actionCards.add(new TurboDuck(pond));
        actionCards.add(new DuckDance(pond));


        Collections.shuffle(actionCards);
    }




    public ArrayList<Card> fillHand(){
        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            cards.add(actionCards.get(0));
            actionCards.remove(0);
        }

        return cards;
    }


    public void returnCard(Card card){
        actionCards.add(card);
    }


    public Card dispenseCard(){
        Card card = actionCards.get(0);
        actionCards.remove(0);

        return card;
    }



    
    
}
