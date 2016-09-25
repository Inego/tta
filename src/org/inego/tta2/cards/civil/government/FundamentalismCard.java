package org.inego.tta2.cards.civil.government;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class FundamentalismCard extends GovernmentCard implements IScienceProductionSource {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Fundamentalism";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getMaxCivilActions() {
        return 6;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 5;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 4;
    }

    @Override
    public int getRevolutionCost() {
        return 7;
    }

    @Override
    public int getNominalResearchCost() {
        return 18;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, this);
        playerState.modifyMilitaryStrengthBase(5 * sign);
    }

    @Override
    public int getScienceProductionValue() {
        return -2;
    }
}
