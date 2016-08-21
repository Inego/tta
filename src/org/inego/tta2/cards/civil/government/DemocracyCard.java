package org.inego.tta2.cards.civil.government;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class DemocracyCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Democracy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getMaxCivilActions() {
        return 7;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 3;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 4;
    }

    @Override
    public int getRevolutionCost() {
        return 9;
    }

    @Override
    public int getFullCost() {
        return 17;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyCultureProduction(sign * 3);
    }
}
