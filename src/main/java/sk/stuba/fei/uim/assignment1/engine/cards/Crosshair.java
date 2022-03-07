package sk.stuba.fei.uim.assignment1.engine.cards;

public class Crosshair extends Card{

    public  Crosshair(short num){
        this.setType(CardType.Crosshair);
        this.incRemaining();
    }
}
