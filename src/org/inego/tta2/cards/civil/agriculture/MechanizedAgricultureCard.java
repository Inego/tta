package org.inego.tta2.cards.civil.agriculture;

import org.inego.tta2.cards.civil.agriculture.FarmCard;

public class MechanizedAgricultureCard extends FarmCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Mechanized Agriculture";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 7;
    }

    @Override
    public int getFoodYield() {
        return 5;
    }
}
