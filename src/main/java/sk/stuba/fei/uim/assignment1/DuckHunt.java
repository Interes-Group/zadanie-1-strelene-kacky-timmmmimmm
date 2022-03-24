package sk.stuba.fei.uim.assignment1;

import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

public class DuckHunt extends ValidInput {




    public  DuckHunt(){

        System.out.println("Welcome to Duck Hunt!");

        byte numOfPlayers = playerCount();


        Pond pond = new Pond(numOfPlayers);





    }
}
