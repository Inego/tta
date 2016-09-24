package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class ChristopherColumbusCard extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Christopher Columbus";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Nothing. See Colonization special political action
    }
}
