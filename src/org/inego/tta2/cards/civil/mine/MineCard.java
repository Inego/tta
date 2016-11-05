package org.inego.tta2.cards.civil.mine;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

public abstract class MineCard extends BuildingCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.MINE;
    }

    public abstract int getProductionYield();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.setRecalcResourceProduction();
    }
}
