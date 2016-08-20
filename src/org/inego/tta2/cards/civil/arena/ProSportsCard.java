package org.inego.tta2.cards.civil.arena;

/**
 * Created by Inego on 20.08.2016.
 */
public class ProSportsCard extends ArenaCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Professional Sports";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 7;
    }
}
