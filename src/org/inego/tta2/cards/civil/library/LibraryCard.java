package org.inego.tta2.cards.civil.library;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class LibraryCard extends BuildingCard{

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.LIBRARY;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyCultureProduction(sign * getAge());
        playerState.modifyScienceProduction(sign * getAge());
    }
}
