package org.inego.tta2.cards.civil.arena;

/**
 * Created by Inego on 20.08.2016.
 */
public class BreadNCircusesCard extends ArenaCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Bread & Circuses";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 3;
    }
}
