package sk.stuba.fei.uim.assignment1.engine;

import sk.stuba.fei.uim.assignment1.actioncards.cards.Card;
import sk.stuba.fei.uim.assignment1.actioncards.container.ActionCards;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class GameManager extends ValidInput {

    private ActionCards actionCards;
    private ArrayList<Player> players;
    private ArrayList<Boolean> reticles;

    public GameManager(Pond pond, ActionCards actionCards, ArrayList<Player> players){

        this.actionCards = actionCards;
        this.players = players;
        this.reticles = pond.accessAim();
    }

    public GameManager(){}

    public void useCard(byte playerPosition){

        boolean allAim = checkAllAimCards(playerPosition);
        boolean allShoot = checkAllShootCards(playerPosition);
        boolean noReticle = checkAllReticles();


        byte cardIndex = 0;
        Card actionCard;


        while (true){

            if((allShoot && noReticle)  ||  (allAim && !noReticle)){
                System.out.println("Currently you can not play any cards, unfortunately you have to forfeit this round");
                actionCard = players.get(playerPosition).useCard(cardIndex);
                break;
            }

            cardIndex = chooseActionCard();
            actionCard = players.get(playerPosition).useCard(cardIndex);

            if(noReticle && Objects.equals("Shoot",actionCard.toString())){
                System.out.println("You can not shoot right now, please stop, you might hurt someone");
                continue;
            }

            if(!actionCard.use())
                break;

            System.out.println("Try choosing another card looks like " + actionCard + " is not the one");
        }

        actionCards.returnCard(actionCard);
        players.get(playerPosition).deleteCard(cardIndex);
        players.get(playerPosition).receiveCard(actionCards.dispenseCard());

    }

    private boolean checkAllShootCards(byte playerPosition){
        boolean allShoot = true;

        for(Card card : players.get(playerPosition).getHand()){

            if(!Objects.equals("Shoot",card.toString())){
                allShoot = false;
                break;
            }
        }

        return allShoot;
    }

    private boolean checkAllAimCards(byte playerPosition){

        boolean allAim = true;

        for(Card card : players.get(playerPosition).getHand()){
            if(!Objects.equals("Aim",card.toString())){
                allAim = false;

            }
        }

        return allAim;
    }

    private boolean checkAllReticles(){

        boolean noReticle = true;

        for(boolean reticle : reticles)
            if(reticle){
                noReticle = false;
                break;
            }

        return noReticle;
    }





    public boolean canPlayShoot(ArrayList<Boolean> reticles, Card actionCard){

        boolean noReticle = true;


        for(boolean reticle : reticles)
            if(reticle){
                noReticle = false;
                break;
            }


        return !(noReticle && Objects.equals("Shoot", actionCard.toString()));  //dont read too much into this, its just a NAND function
    }


    public void checkPlayerStatus(){
        for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
            Player player = iterator.next();
            if(player.checkIfDead()) {
                System.out.println("\nLooks like its the end of the line for you " + player.name() + "\nGG and well, better luck next time");

                for (Card card : player.getHand())
                    actionCards.returnCard(card);

                iterator.remove();
            }
        }
    }
}
