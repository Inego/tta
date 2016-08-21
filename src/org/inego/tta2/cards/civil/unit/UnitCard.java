package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class UnitCard extends BuildingCard {

    protected abstract int getStrength();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrength(getStrength());
    }
}
