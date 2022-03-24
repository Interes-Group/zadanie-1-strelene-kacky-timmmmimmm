package sk.stuba.fei.uim.assignment1.cards;


import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;

public class Aim extends ValidInput implements Card{

   ArrayList<Boolean> aim;

    public Aim(Pond pond){
        aim = pond.accessAim();
    }


    @Override
    public boolean use() {

        int aimAt;

        aimAt = aimPosition(aim);

        if(aimAt == -1)
            return true;

        aim.set(aimAt,true);

        return false;
    }


    @Override
    public String toString() {
        return "Aim";
    }
}
