package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class LeonardoDaVinciCard extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Leonardo da Vinci";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Special powers
    }
}
