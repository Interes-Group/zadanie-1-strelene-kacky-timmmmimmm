package sk.stuba.fei.uim.assignment1.player;

import sk.stuba.fei.uim.assignment1.actioncards.cards.Card;

import java.util.ArrayList;

public class Player {

    private final String name;
    private final ArrayList<Card> hand = new ArrayList<>();
    private final byte ID;
    private byte health = 5;


    public Player(String name, byte ID){

        this.name = name;
        this.ID = ID;
    }


    public void setHand(ArrayList<Card> hand){
        if(!this.hand.isEmpty()){
            this.hand.clear();
        }
        else
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


    /**
     * Returns the contents of private field hand, any changes to the returned field will not affect the original field
     * @return copy of private field hand
     */
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
