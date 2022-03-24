package sk.stuba.fei.uim.assignment1.engine;

import sk.stuba.fei.uim.assignment1.actioncards.cards.Card;
import sk.stuba.fei.uim.assignment1.actioncards.container.ActionCards;
import sk.stuba.fei.uim.assignment1.player.Player;
import sk.stuba.fei.uim.assignment1.pond.Pond;
import sk.stuba.fei.uim.assignment1.utility.ValidInput;

import java.util.ArrayList;
import java.util.Objects;

public class CardManager extends ValidInput {

    ActionCards actionCards;
    ArrayList<Player> players;
    ArrayList<Boolean> reticles;

    public CardManager(Pond pond,ActionCards actionCards, ArrayList<Player> players){

        this.actionCards = actionCards;
        this.players = players;
        this.reticles = pond.accessAim();
    }

    public CardManager(){}

    public void useCard(byte playerPosition){

        boolean allAim = true;
        boolean allShoot = true;
        boolean noReticle = true;


        for(Card card : players.get(playerPosition).getHand()){

            if(!Objects.equals("Shoot",card.toString())){
                allShoot = false;
                break;
            }
        }

        for(Card card : players.get(playerPosition).getHand()){
            if(!Objects.equals("Aim",card.toString())){
                allAim = false;

            }
        }

        for(boolean reticle : reticles)
            if(reticle){
                noReticle = false;
                break;
            }





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


    public boolean canPlayShoot(ArrayList<Boolean> reticles, Card actionCard){

        boolean noReticle = true;


        for(boolean reticle : reticles)
            if(reticle){
                noReticle = false;
                break;
            }


        return !(noReticle && Objects.equals("Shoot", actionCard.toString()));
    }
}
