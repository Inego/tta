package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class LabCard extends BuildingCard {

    @Override
    public CivilCardKind getCivilCardKind() {
        return CivilCardKind.LAB;
    }

    public abstract int getScienceYield();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProduction(sign * getScienceYield());
    }
}
