package org.inego.tta2.cards.civil.unit;

/**
 * Created by Inego on 21.08.2016.
 */
public class WarriorsCard extends InfantryCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Warriors";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getBuildCost() {
        return 2;
    }

    @Override
    public int getResearchCost() {
        return 0;
    }

    @Override
    protected int getStrength() {
        return 1;
    }
}
