package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.happiness.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class TheaterCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.THEATER;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyHappinessSource(HappinessSource.THEATER, sign);
    }
}
