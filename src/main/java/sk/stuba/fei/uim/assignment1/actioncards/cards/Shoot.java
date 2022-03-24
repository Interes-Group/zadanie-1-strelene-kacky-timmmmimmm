package sk.stuba.fei.uim.assignment1.actioncards.cards;

import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;

public class Shoot extends ValidInput implements Card {

    ArrayList<Integer> arena;
    ArrayList<Integer> remaining;
    ArrayList<Boolean> aim;
    ArrayList<Player> players;


    public Shoot(Pond pond, ArrayList<Player> players){

        arena = pond.accessArena();
        remaining = pond.accessRest();
        aim = pond.accessAim();
        this.players = players;
    }



    @Override
    public boolean use() {

        int whereShoot = fireAt(aim);

        if (whereShoot == -1)
            return true;

        aim.set(whereShoot,false);
        int shotDuck = arena.get(whereShoot);

        if(shotDuck == 0){
            System.out.println("Lul you shot water");
            return false;
        }

        arena.remove(whereShoot);
        arena.add(remaining.get(0));
        remaining.remove(0);

        for (Player player : players){
            if(player.getID() == shotDuck){
                player.loseHealth();
            }
        }

        return false;
    }


    @Override
    public String toString(){
        return "Shoot";
    }


}
