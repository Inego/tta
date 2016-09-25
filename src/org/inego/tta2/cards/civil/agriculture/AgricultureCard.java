package org.inego.tta2.cards.civil.agriculture;

/**
 *
 */
public class AgricultureCard extends FarmCard {

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Agriculture";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getNominalResearchCost() {
        return 0;
    }

    @Override
    public int getNominalCost() {
        return 2;
    }

    @Override
    public int getFoodYield() {
        return 1;
    }
}
