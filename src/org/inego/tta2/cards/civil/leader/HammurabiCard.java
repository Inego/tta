package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 10.09.2016.
 */
public class HammurabiCard extends LeaderCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Hammurabi";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        if(sign == 1) {
            playerState.enableLeaderSpecialAction();
        }
    }
}
