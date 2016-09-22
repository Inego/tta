package org.inego.tta2.cards.civil.unit;

/**
 *
 */
public class SwordsmenCard extends InfantryCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Swordsmen";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 4;
    }

    @Override
    protected int getStrength() {
        return 2;
    }
}
