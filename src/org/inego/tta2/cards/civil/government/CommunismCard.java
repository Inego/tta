package org.inego.tta2.cards.civil.government;

import org.inego.tta2.gamestate.happiness.GovernmentHappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class CommunismCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Communism";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getMaxCivilActions() {
        return 7;
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
        return 5;
    }

    @Override
    public int getNominalResearchCost() {
        return 19;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyHappinessSource(GovernmentHappinessSource.COMMUNISM, sign);
    }
}
