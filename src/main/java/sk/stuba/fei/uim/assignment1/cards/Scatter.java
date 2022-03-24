package sk.stuba.fei.uim.assignment1.cards;

import sk.stuba.fei.uim.assignment1.pond.Pond;

import java.util.ArrayList;
import java.util.Collections;

public class Scatter implements Card{

    ArrayList<Integer> arena;

    public Scatter(Pond pond){
        arena = pond.accessArena();
    }


    @Override
    public boolean use() {

        Collections.shuffle(arena);

        return false;
    }

    @Override
    public String toString(){
        return "Scatter";
    }


}
