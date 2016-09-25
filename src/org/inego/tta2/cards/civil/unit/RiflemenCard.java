package org.inego.tta2.cards.civil.unit;

/**
 *
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
    public int getNominalCost() {
        return 5;
    }

    @Override
    public int getNominalResearchCost() {
        return 6;
    }

    @Override
    protected int getStrength() {
        return 3;
    }
}
