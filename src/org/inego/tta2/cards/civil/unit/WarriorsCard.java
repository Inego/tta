package org.inego.tta2.cards.civil.unit;

/**
 *
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
    public int getNominalCost() {
        return 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 0;
    }

    @Override
    protected int getStrength() {
        return 1;
    }
}
