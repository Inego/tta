package org.inego.tta2.cards.civil.government;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class FundamentalismCard extends GovernmentCard {
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
    public int getFullCost() {
        return 18;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyScienceProduction(-2 * sign);
        playerState.modifyMilitaryStrength(5 * sign);
    }
}
