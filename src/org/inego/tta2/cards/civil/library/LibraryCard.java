package org.inego.tta2.cards.civil.library;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public abstract class LibraryCard extends BuildingCard implements IScienceProductionSource {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.LIBRARY;
    }

    @Override
    public int getBuildingCost(PlayerState playerState) {
        int buildingCost = super.getBuildingCost(playerState);
        if (playerState.getLeader() == Cards.WILLIAM_SHAKESPEARE && playerState.hasTheaters())
            buildingCost -= 1;
        return buildingCost;
    }

    @Override
    public int getResearchCost(PlayerState playerState) {
        int researchCost = super.getResearchCost(playerState);
        if (playerState.getLeader() == Cards.WILLIAM_SHAKESPEARE && playerState.hasTheaters())
            researchCost -= 1;
        return researchCost;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, this);
    }
}
