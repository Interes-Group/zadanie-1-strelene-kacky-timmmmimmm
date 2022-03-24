package sk.stuba.fei.uim.assignment1.cards;

import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;

public class WildBill extends ValidInput implements Card {

    ArrayList<Integer> arena;
    ArrayList<Integer> remaining;
    ArrayList<Boolean> aim;
    ArrayList<Player> players;


    public WildBill(Pond pond, ArrayList<Player> players){
        arena = pond.accessArena();
        remaining = pond.accessRest();
        aim = pond.accessAim();
        this.players = players;
    }



    @Override
    public boolean use() {

        int whereToShoot = fireAt();

        if(whereToShoot == -1)
            return true;

        int shotDuck = arena.get(whereToShoot);
        aim.set(whereToShoot,false);

        if(shotDuck == 0){
            System.out.println("Water? With this card? Bruh.");
            return false;
        }

        arena.remove(whereToShoot);
        arena.add(remaining.get(0));
        remaining.remove(0);

        for (Player player : players){
            if(player.getID() == shotDuck)
                player.loseHealth();
        }

        return false;
    }



    @Override
    public String toString(){
        return "Wild Bill";
    }

}
