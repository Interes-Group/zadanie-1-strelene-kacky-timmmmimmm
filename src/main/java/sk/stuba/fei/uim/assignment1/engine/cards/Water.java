package sk.stuba.fei.uim.assignment1.engine.cards;

public class Water extends Card{
    Water(byte num){

        this.setType(CardType.Water);
        this.setName("Water" + num);
        this.incRemaining();
    }
}
