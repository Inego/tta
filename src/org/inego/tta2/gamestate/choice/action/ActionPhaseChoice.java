package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 *
 */
public abstract class ActionPhaseChoice extends Choice {

    public static final ActionPhaseChoice PASS = new ActionPhaseChoice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.endTurn();
        }
    };

}
