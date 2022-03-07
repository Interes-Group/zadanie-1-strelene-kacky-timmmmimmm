package sk.stuba.fei.uim.assignment1.engine.cards;

public class Action extends Card{

   public Action(ActionCard type, byte owner){
        this.setType(CardType.Action);
        this.setAcionType(type);
        this.setOwner(owner);
        this.incRemaining();
    }

}
