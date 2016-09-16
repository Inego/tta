package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 11.09.2016.
 */
public class MichelangeloCard extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Michelangelo";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.setRecalcCultureProduction();

        // TODO take wonder without penalty
    }
}
