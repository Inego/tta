package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 * Created by Inego on 11.09.2016.
 */
public class AlexanderCard extends LeaderCard {
    public static final Choice REMOVE = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.removeCurrentLeader();
            playerState.gainYellowTokens(1);
        }
    };

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Alexander the Great";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.setRecalcMilitaryStrength();
    }
}
