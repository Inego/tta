package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class MosesCard extends LeaderCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Moses";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Do nothing (see bonus in getFoodProductionCost)
    }
}
