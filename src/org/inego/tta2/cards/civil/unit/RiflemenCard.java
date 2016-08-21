package org.inego.tta2.cards.civil.unit;

/**
 * Created by Inego on 21.08.2016.
 */
public class RiflemenCard extends InfantryCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Riflemen";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 5;
    }

    @Override
    public int getResearchCost() {
        return 6;
    }

    @Override
    protected int getStrength() {
        return 3;
    }
}
