package sk.stuba.fei.uim.assignment1.actioncards.cards;

import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;
import java.util.Collections;

public class TurboDuck extends ValidInput implements Card {


    ArrayList<Integer> arena;


    public TurboDuck(Pond pond){
        arena = pond.accessArena();
    }


    @Override
    public boolean use() {

        int duckPos = getDuckPos(arena);

        if(duckPos == -1)
            return true;

        Collections.swap(arena,0,duckPos);

        return false;
    }




    @Override
    public String toString(){
        return "Turbo Duck";
    }
}
