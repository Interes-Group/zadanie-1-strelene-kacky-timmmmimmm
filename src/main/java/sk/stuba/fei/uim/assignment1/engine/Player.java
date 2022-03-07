package sk.stuba.fei.uim.assignment1.engine;

import sk.stuba.fei.uim.assignment1.engine.cards.Action;
import sk.stuba.fei.uim.assignment1.engine.cards.Duck;

public class Player {
    byte ID;
    Duck[] ducks = new Duck[5];
    Action[] actionCards = new Action[3];
    boolean winner = false;
}
