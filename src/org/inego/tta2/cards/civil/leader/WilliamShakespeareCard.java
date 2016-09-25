package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.LeaderHappinessSource;

/**
 *
 */
public class WilliamShakespeareCard extends LeaderCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "William Shakespeare";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyHappinessSource(LeaderHappinessSource.WILLIAM_SHAKESPEARE, sign);
        playerState.setRecalcCultureProduction();
    }
}
