package org.inego.tta2.cards.military.colony;

import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.cards.military.MilitaryCardKind;
import org.inego.tta2.gamestate.PlayerState;

public abstract class ColonyCard extends MilitaryCard {

    public abstract void immediateBonus(PlayerState playerState);

    public abstract void onGain(int sign, PlayerState playerState);

    @Override
    public MilitaryCardKind getKind() {
        return MilitaryCardKind.COLONY;
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
