package sk.stuba.fei.uim.assignment1.engine.cards;

public class Card {



    private CardType type;
    private String name;
    private ActionCard acionType;
    private byte owner;
    private boolean alive;
    private boolean used;
    private short remaining = 0;





    public CardType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ActionCard getAcionType() {
        return acionType;
    }

    public byte getOwner() {
        return owner;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isUsed() {
        return used;
    }

    public short getRemaining() {
        return remaining;
    }




    public void setType(CardType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcionType(ActionCard acionType) {
        this.acionType = acionType;
    }

    public void setOwner(byte owner) {
        this.owner = owner;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }





    public void incRemaining() {
        this.remaining ++;
    }

    public void decRemaining(){
        this.remaining --;
    }


}
