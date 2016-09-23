package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class AlchemyCard extends LabCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Alchemy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getBuildCost() {
        return 6;
    }

    @Override
    public int getResearchCost() {
        return 4;
    }


    @Override
    public int getScienceProductionValue() {
        return 2;
    }
}
