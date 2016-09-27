package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.happiness.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class TheaterCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.THEATER;
    }

    @Override
    public int getBuildingCost(PlayerState playerState) {
        int buildingCost = super.getBuildingCost(playerState);
        if (playerState.getLeader() == Cards.WILLIAM_SHAKESPEARE && playerState.hasLibraries())
            buildingCost -= 1;
        return buildingCost;
    }

    @Override
    public int getResearchCost(PlayerState playerState) {
        int researchCost = super.getResearchCost(playerState);
        if (playerState.getLeader() == Cards.WILLIAM_SHAKESPEARE) {
            if (playerState.hasLibraries()) {
                researchCost -= 1;
            }
        }
        else if (playerState.getLeader() == Cards.JS_BACH) {
            researchCost -= 2;
        }
        return researchCost;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyHappinessSource(HappinessSource.THEATER, sign);
    }
}
