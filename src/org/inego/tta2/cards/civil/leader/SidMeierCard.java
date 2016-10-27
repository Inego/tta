package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.10.2016.
 */
public class SidMeierCard extends LeaderCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Sid Meier";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.setRecalcCultureProduction();
        playerState.setRecalcScienceProduction();
    }
}
