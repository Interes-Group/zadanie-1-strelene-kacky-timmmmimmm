package sk.stuba.fei.uim.assignment1.player;

import sk.stuba.fei.uim.assignment1.cards.Card;

import java.util.ArrayList;

public class Player {

    private final String name;
    private final ArrayList<Card> hand = new ArrayList<>();
    private final byte ID;
    private byte health = 5;


    public Player(String name, byte ID, ArrayList<Card> hand){

        this.name = name;
        this.ID = ID;
        this.hand.addAll(hand);
    }



    public byte getID(){
        return ID;
    }

    public void loseHealth(){
        health --;
    }

    public String name(){
        return name;
    }


    public Card useCard(byte which){

        Card card = hand.get(which);
        hand.remove(which);

        return card;

    }

    public void receiveCard(Card card){
        hand.add(card);
    }



    public ArrayList<Card> getHand(){

        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            hand.add(this.hand.get(0));
        }

        return hand;
    }

    public boolean checkIfDead(){
        return health >= 1;
    }


}
