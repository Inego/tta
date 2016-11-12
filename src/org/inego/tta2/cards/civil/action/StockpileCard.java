package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 12.11.2016.
 */
public class StockpileCard extends SimpleActionCard {

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Stockpile";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    protected void performAction(PlayerState playerState) {
        playerState.gainResources(1);
        playerState.gainFood(1);
    }
}
