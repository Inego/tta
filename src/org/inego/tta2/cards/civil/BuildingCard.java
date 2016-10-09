package org.inego.tta2.cards.civil;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class BuildingCard extends CivilCard implements ITechnologyCard {

    public abstract int getNominalCost();

    public abstract void assignWorker(int sign, PlayerState playerState);

    public int getBuildingCost(PlayerState playerState) {
        return getNominalCost();
    }

}
