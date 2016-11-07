package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.PlayerState;

public class CulturalHeritage1Card extends SimpleActionCard {

    @Override
    protected void performAction(PlayerState playerState) {
        playerState.gainSciencePoints(2);
        playerState.gainCulturePoints(2);
    }

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Cultural Heritage 1";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
