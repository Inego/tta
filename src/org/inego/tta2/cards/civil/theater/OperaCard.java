package org.inego.tta2.cards.civil.theater;

/**
 * Created by Inego on 21.08.2016.
 */
public class OperaCard extends TheaterCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Theater";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
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