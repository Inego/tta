package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

public class IsaacNewtonCard extends LeaderCard {

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Isaac Newton";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Nothing
    }
}
