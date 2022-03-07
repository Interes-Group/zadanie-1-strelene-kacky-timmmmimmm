package sk.stuba.fei.uim.assignment1.engine.cards;

import sk.stuba.fei.uim.assignment1.engine.cards.Card;
import sk.stuba.fei.uim.assignment1.engine.cards.CardType;

public class Duck extends Card {

    public Duck(byte ownerID, byte duckNum){
        this.setType(CardType.Duck);
        this.setName("Quack " + duckNum);
        this.setOwner(ownerID);
        this.setAlive(true);
        this.incRemaining();
    }


    void dies(){
        this.setAlive(false);
    }
}
