package org.inego.tta2.cards.civil.unit;

/**
 *
 */
public class CavalrymenCard extends CavalryCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Cavalrymen";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 6;
    }

    @Override
    public int getNominalCost() {
        return 5;
    }

    @Override
    protected int getStrength() {
        return 3;
    }
}
