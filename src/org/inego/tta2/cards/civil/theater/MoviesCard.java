package org.inego.tta2.cards.civil.theater;

/**
 * Created by Inego on 21.08.2016.
 */
public class MoviesCard extends TheaterCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Movies";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 11;
    }

    @Override
    public int getResearchCost() {
        return 10;
    }
}