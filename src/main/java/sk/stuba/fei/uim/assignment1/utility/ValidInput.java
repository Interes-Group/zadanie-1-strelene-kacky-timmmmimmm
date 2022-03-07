package sk.stuba.fei.uim.assignment1.utility;

import java.io.IOException;
import java.util.Scanner;

public class ValidInput {

   public byte playerCount(){

       Scanner input = new Scanner(System.in);
       byte playerCnt;

       System.out.print("Please choose the number of players(2 - 6): ");

        while (true){

            try {
                playerCnt = (byte) input.nextInt();

                if(playerCnt >= 2  &&  playerCnt <= 6)
                    break;

                else if(playerCnt == -1){
                    return -1;
                }

                System.out.print("Invalid number of players!\nPlease choose a valid number.\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                String trowOut = input.next();
            }
        }

        input.close();
        return playerCnt;
    }
}
