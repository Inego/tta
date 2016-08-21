package org.inego.tta2.cards.civil.unit;

/**
 * Created by Inego on 21.08.2016.
 */
public class KnightsCard extends CavalryCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Knights";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getResearchCost() {
        return 5;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    protected int getStrength() {
        return 2;
    }
}