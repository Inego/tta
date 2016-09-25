package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class JamesCookCard extends LeaderCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "James Cook";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.setRecalcCultureProduction();

        // TODO James Cook special colonization ability
    }
}
