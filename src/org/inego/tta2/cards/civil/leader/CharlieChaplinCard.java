package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.LeaderHappinessSource;

public class CharlieChaplinCard extends LeaderCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Charlie Chaplin";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyHappinessSource(LeaderHappinessSource.CHARLIE_CHAPLIN, sign);
        playerState.setRecalcCultureProduction();
    }
}
