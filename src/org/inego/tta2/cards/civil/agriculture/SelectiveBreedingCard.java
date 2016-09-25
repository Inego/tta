package org.inego.tta2.cards.civil.agriculture;

import org.inego.tta2.cards.civil.agriculture.FarmCard;

/**
 *
 */
public class SelectiveBreedingCard extends FarmCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Selective Breeding";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers - 1;
    }

    @Override
    public int getNominalCost() {
        return 6;
    }

    @Override
    public int getNominalResearchCost() {
        return 5;
    }

    @Override
    public int getFoodYield() {
        return 3;
    }
}
