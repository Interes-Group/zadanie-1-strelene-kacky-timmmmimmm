package sk.stuba.fei.uim.assignment1.actioncards.cards;

import sk.stuba.fei.uim.assignment1.pond.Pond;

import java.util.ArrayList;
import java.util.Collections;

public class DuckDance implements Card {

    ArrayList<Integer> arena;
    ArrayList<Integer> remaining;


    public DuckDance(Pond pond){
        arena = pond.accessArena();
        remaining = pond.accessRest();
    }


    @Override
    public boolean use() {

        remaining.addAll(arena);
        arena.clear();


        Collections.shuffle(remaining);

        for (byte i = 0; i < 6; i++) {
            arena.add(remaining.get(0));
            remaining.remove(0);
        }


        return false;
    }


    @Override
    public String toString() {

        return "Duck Dance";
    }
}
