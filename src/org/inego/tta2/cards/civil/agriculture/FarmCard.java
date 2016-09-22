package org.inego.tta2.cards.civil.agriculture;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class FarmCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.FARM;
    }

    public abstract int getFoodYield();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyFoodProduction(sign * getFoodYield());
    }

}
