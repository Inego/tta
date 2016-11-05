package org.inego.tta2.cards.military.tactic;

import org.inego.tta2.cards.civil.action.SimpleActionCard;
import org.inego.tta2.gamestate.PlayerState;

public class CulturalHeritageACard extends SimpleActionCard {

    @Override
    protected void performAction(PlayerState playerState) {
        playerState.gainSciencePoints(1);
        playerState.gainCulturePoints(4);
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Cultural Heritage A";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
