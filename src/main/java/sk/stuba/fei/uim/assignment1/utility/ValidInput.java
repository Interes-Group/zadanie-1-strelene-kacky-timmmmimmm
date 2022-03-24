package sk.stuba.fei.uim.assignment1.utility;


import java.util.ArrayList;
import java.util.Scanner;

//welcome to the most copypasta classes of them all the input verifier
//tbh this should be an abstract class with static methods BUT StAtIc MeThOdS aRe NoT aLlOwEd

public abstract class  ValidInput {
    Scanner input = new Scanner(System.in);



    public byte playerCount(){

       byte playerCnt;

       System.out.print("Please choose the number of players(2 - 6): ");

        while (true){

            try {
                playerCnt = input.nextByte();

                if(playerCnt >= 2  &&  playerCnt <= 6)
                    break;

                else if(playerCnt == -1){
                    return -1;
                }

                System.out.print("Invalid number of players!\nPlease choose a valid number.(-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }
        return playerCnt;
    }




    public int aimPosition(ArrayList<Boolean> field){

       int position;

        System.out.print("Please choose the place you want to aim at (1 - 6) : ");

        while (true){

            try {
                position = input.nextInt();

                if(position >= 1  &&  position <= 6){

                    if(!field.get(position-1))
                        break;
                    System.out.println("Your desired position has a reticle already aimed at it");
                }

                else if(position == -1)
                    return -1;


                System.out.print("Invalid field!\nPlease choose a valid number.(-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }

        return position -1;
    }





    public int getDuckPos(ArrayList<Integer> arena){

        int position;

        System.out.print("Please choose a place from which to pull a duck to the 1st position (1 - 6) : ");

        while (true){

            try {
                position = input.nextInt();

                if(position >= 1  &&  position <= 6){

                    if(arena.get(position-1) != 0)
                        break;
                    System.out.println("You have to choose a duck!");
                }

                else if(position == -1)
                    return -1;


                System.out.print("Invalid field!\nPlease choose a valid number.(-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }

        return position -1;
    }



    /**
     * Checks if you can shoot at the desired field
     * @return input position
     */
    public int fireAt(ArrayList<Boolean> aim){
        int position;

        System.out.print("Please choose a field which to shoot at :");

        while (true){

            try {
                position = input.nextInt();

                if(position >= 1  &&  position <= 6){

                    if(aim.get(position-1))
                        break;
                    System.out.println("Field must be aimed at!");
                }

                else if(position == -1)
                    return -1;


                System.out.print("Invalid field!\nPlease choose a valid number.(-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }

        return position -1;
    }



    /**
     * Checks if you can shoot at the desired field (without checking reticules)
     * @return input position
     */
    public int fireAt(){
        int position;

        System.out.print("Please choose a field which to shoot at: ");

        while (true){

            try {
                position = input.nextInt();

                if(position >= 1  &&  position <= 6)
                    break;


                else if(position == -1)
                    return -1;


                System.out.print("Invalid field!\nPlease choose a valid number.(-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }

        return position -1;
    }



    public String getName(){

        String name;


        while (true){
            try {
                name = input.next();
            }

            catch (java.util.InputMismatchException e){
                System.out.println("Something went wrong, try something else");
                continue;
            }

            break;
        }


        return name;
    }


    public byte chooseActionCard(){
        byte card;
        while (true){

            System.out.print("Choose a card you want to play: ");

            try {
                card = input.nextByte();

                if(card >= 1  &&  card <= 3)
                    break;

                System.out.print("Invalid field!\nPlease choose a valid number. (-1 to quit)\nYour choice: ");
            }

            catch (java.util.InputMismatchException e){
                //e.printStackTrace();  //Can be enabled, but it is really messy
                System.out.print("Please Enter a number: ");
                input.next();
            }
        }

        return (byte) (card - 1);
    }

}
