package org.inego.tta2.cards.civil.agriculture;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class FarmCard extends BuildingCard {

    @Override
    public CivilCardKind getCivilCardKind() {
        return CivilCardKind.FARM;
    }

    public abstract int getFoodYield();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyFoodProduction(sign * getFoodYield());
    }

}