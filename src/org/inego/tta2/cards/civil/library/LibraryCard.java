package org.inego.tta2.cards.civil.library;

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
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, this);
    }
}
