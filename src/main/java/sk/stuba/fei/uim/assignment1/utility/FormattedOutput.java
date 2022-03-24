package sk.stuba.fei.uim.assignment1.utility;

import sk.stuba.fei.uim.assignment1.engine.CardManager;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;

import java.util.ArrayList;
import java.util.Map;


// I get that static functions are widely misused but come on

public abstract class FormattedOutput{

    CardManager check = new CardManager();

    public void drawPlayground (Pond pond, ArrayList<Player> players, byte currentPlayer, int round, ArrayList<String> names){
        System.out.println("------\t\t\tRound " + round + "\t\t\t---------");
        System.out.println(" Index\t\t\tReticle\t\t\t    Ducks\n");
        for(int i = 0; i < 6; i++){
            System.out.println("| " + (i+1) + "  \t\t\t" +
                    (pond.accessAim().get(i) ? " Locked " : "Unlocked") + "\t\t\t" +
                    (pond.accessArena().get(i) == 0 ? "Water" : names.get(pond.accessArena().get(i)-1) + "´s duck"));
        }
        System.out.println();

        System.out.println("Hey " + players.get(currentPlayer).name() + " its your turn!");
        System.out.println("You are currently on " + players.get(currentPlayer).checkhealth() + " HP\n");
        System.out.println("This is what you can play:");

        for (int i = 0; i < 3; i++){
            System.out.println("Press " + (i+1) + " for " +
                    (check.canPlayShoot(pond.accessAim(),players.get(currentPlayer).getHand().get(i)) ?
                            players.get(currentPlayer).getHand().get(i) : players.get(currentPlayer).getHand().get(i) + " (unplayable)"));
        }
        System.out.println();
    }



}
