package org.inego.tta2.cards.civil;

import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 16.08.2016.
 */
public abstract class BuildingCard extends CivilCard {

    public abstract int getBuildCost();

    public abstract int getResearchCost();

    public abstract void assignWorker(int sign, PlayerState playerState);

}
