package org.inego.tta2.cards.civil.unit;

/**
 *
 */
public class CannonCard extends ArtilleryCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Cannon";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
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
