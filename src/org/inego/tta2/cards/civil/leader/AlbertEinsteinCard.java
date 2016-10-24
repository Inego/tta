package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class AlbertEinsteinCard extends LeaderCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Albert Einstein";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Nothing
    }
}
