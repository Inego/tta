package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class LeaderCard extends CivilCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.LEADER;
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    public abstract void onElect(int sign, PlayerState playerState, LeaderCard other);
}
