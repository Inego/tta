package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.point.GamePoint;

/**
 *
 */
public class JuliusCaesarCard extends LeaderCard {

    public static final GamePoint POINT = new GamePoint() {
        @Override
        public void apply(GameState gameState, PlayerState playerState) {
            // TODO Julius Caesar action
        }
    };


    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Julius Caesar";
    }


    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {

        playerState.modifyMilitaryStrengthBase(sign);
        playerState.modifyAdditionalMilitaryActions(sign);

        if(sign == 1) {
            playerState.enableLeaderSpecialAction();
        }
    }
}
