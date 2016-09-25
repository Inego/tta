package org.inego.tta2.cards.civil.unit;

/**
 *
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
    public int getNominalResearchCost() {
        return 5;
    }

    @Override
    public int getNominalCost() {
        return 3;
    }

    @Override
    protected int getStrength() {
        return 2;
    }
}
