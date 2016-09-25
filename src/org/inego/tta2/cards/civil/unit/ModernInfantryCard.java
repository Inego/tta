package org.inego.tta2.cards.civil.unit;

/**
 *
 */
public class ModernInfantryCard extends InfantryCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Modern Infantry";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getNominalCost() {
        return 7;
    }

    @Override
    public int getNominalResearchCost() {
        return 10;
    }

    @Override
    protected int getStrength() {
        return 5;
    }
}
