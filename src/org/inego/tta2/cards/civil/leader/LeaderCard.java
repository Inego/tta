package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
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

    @Override
    public int getTakingCost(int baseCost, PlayerState playerState) {
        int takingCost = super.getTakingCost(baseCost, playerState);
        if (playerState.getLeader() == Cards.HAMMURABI) {
            return --takingCost; // Can't become less than zero?
        }
        return takingCost;
    }
}
