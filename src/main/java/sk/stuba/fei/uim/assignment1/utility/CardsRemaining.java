package sk.stuba.fei.uim.assignment1.utility;

public class CardsRemaining {

    private byte aim = 10,      //rework to map
            shoot = 12,
            wildBill = 2,
            duckMarch = 6,
            turboDuck = 1,
            scatter = 2,
            duckDance = 1;

    private boolean empty = false;



    public byte cardRemaining(int key){
        if(key == 0)         return aim;
        else if(key == 1)    return shoot;
        else if(key == 2)    return wildBill;
        else if(key == 3)    return duckMarch;
        else if(key == 4)    return turboDuck;
        else if(key == 5)    return scatter;
        else if(key == 6)    return duckDance;


        return 0;
    }


    public void decrementValue(int key){
        if(key == 0)         aim--;
        else if(key == 1)    shoot--;
        else if(key == 2)    wildBill--;
        else if(key == 3)    duckMarch--;
        else if(key == 4)    turboDuck--;
        else if(key == 5)    scatter --;
        else if(key == 6)    duckDance--;
    }
}
