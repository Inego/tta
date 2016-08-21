package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class TempleCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TEMPLE;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyCultureProduction(sign);
        playerState.modifyHappiness(sign * (getAge() + 1));
    }
}
