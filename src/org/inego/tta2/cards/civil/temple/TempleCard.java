package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.BuildingCultureProductionSource;

/**
 *
 */
public abstract class TempleCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TEMPLE;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyCultureProductionSource(sign, BuildingCultureProductionSource.TEMPLE);
        // Happiness overridden
    }
}
