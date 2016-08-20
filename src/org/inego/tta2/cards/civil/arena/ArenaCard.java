package org.inego.tta2.cards.civil.arena;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class ArenaCard extends BuildingCard {

    @Override
    public CivilCardKind getCivilCardKind() {
        return CivilCardKind.ARENA;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrength(sign * getAge());
        playerState.modifyHappiness(sign * (getAge() + 1));
    }
}
