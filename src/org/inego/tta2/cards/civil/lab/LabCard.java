package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public abstract class LabCard extends BuildingCard implements IScienceProductionSource {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.LAB;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, this);

        if (playerState.getLeader() == Cards.SID_MEIER)
            playerState.setRecalcCultureProduction();
    }

}
