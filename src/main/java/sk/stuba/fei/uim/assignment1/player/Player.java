package sk.stuba.fei.uim.assignment1.player;

import sk.stuba.fei.uim.assignment1.cards.Card;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private byte ID;
    private byte health = 5;


    public Player(String name, byte ID, ArrayList<Card> hand){

        this.name = name;
        this.ID = ID;
        this.hand.addAll(hand);
    }



    public void loseHealth(){
        health --;
    }

}
