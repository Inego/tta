package org.inego.tta2.cards.civil.agriculture;

import org.inego.tta2.cards.civil.agriculture.FarmCard;

/**
 *
 */
public class IrrigationCard extends FarmCard {

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Irrigation";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 4;
    }

    @Override
    public int getNominalResearchCost() {
        return 3;
    }

    @Override
    public int getFoodYield() {
        return 2;
    }
}
