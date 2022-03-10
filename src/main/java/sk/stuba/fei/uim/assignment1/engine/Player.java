package sk.stuba.fei.uim.assignment1.engine;

import sk.stuba.fei.uim.assignment1.engine.cards.Action;
import sk.stuba.fei.uim.assignment1.engine.cards.Duck;

import java.util.ArrayList;

public class Player {
   private byte ID;
   private final ArrayList<Duck> ducks = new ArrayList<>();
   private final ArrayList<Action> actionCards = new ArrayList<>();
   private boolean winner = false;


   public Player(byte ID){
       this.ID = ID;
   }


    public byte getID() {
        return ID;
    }

    public Duck getDuck(byte which) {
        return ducks.get(which);
    }

    public int getDuckArrLen(){
        return ducks.size();
    }

    public Action getActionCard(byte which) {

        return actionCards.get(which);
    }

    public int getActionArrLen(){
        return actionCards.size();
    }

    public boolean isWinner() {
        return winner;
    }





    public void setID(byte ID) {
        this.ID = ID;
    }

    public void setDucks(Duck data, byte pos) {
        this.ducks.add(pos,data);
    }

    public void setActionCards(Action data) {
        this.actionCards.add(data);
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
