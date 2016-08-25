package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class WonderCard extends CivilCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.WONDER;
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    public abstract int[] getBuildingCost();

    public abstract void onBuild(PlayerState playerState);

}
