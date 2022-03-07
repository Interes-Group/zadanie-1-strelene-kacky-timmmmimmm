package sk.stuba.fei.uim.assignment1.utility;


import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

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
                String trowOut = input.next(); //Flushes the std input so it can be reused
            }
        }

        input.close();
        return playerCnt;

    }
}
