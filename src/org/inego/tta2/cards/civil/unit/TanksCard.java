package org.inego.tta2.cards.civil.unit;

/**
 *
 */
public class TanksCard extends CavalryCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Tanks";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 9;
    }

    @Override
    public int getNominalCost() {
        return 7;
    }

    @Override
    protected int getStrength() {
        return 5;
    }
}
