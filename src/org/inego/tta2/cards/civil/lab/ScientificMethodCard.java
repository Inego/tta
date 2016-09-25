package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class ScientificMethodCard extends LabCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Scientific Method";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 8;
    }

    @Override
    public int getNominalResearchCost() {
        return 6;
    }

    @Override
    public int getScienceProductionValue() {
        return 3;
    }
}
