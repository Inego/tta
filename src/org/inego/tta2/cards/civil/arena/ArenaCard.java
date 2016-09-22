package org.inego.tta2.cards.civil.arena;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class ArenaCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.ARENA;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * getAge());
    }
}
