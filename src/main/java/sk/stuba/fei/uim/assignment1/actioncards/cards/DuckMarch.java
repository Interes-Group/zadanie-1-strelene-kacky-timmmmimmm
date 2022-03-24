package sk.stuba.fei.uim.assignment1.actioncards.cards;

import sk.stuba.fei.uim.assignment1.pond.Pond;

import java.util.ArrayList;

public class DuckMarch implements Card{

    ArrayList<Integer> arena;
    ArrayList<Integer> remaining;


    public DuckMarch(Pond pond){
        arena = pond.accessArena();
        remaining = pond.accessRest();
    }




    @Override
    public boolean use() {
        remaining.add(arena.get(0));
        arena.remove(0);
        arena.add(remaining.get(0));
        remaining.remove(0);

        return false;
    }


    @Override
    public String toString() {

        return "Duck March";
    }
}
