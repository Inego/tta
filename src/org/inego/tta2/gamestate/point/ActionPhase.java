package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class ActionPhase extends GamePoint {

    public static final GamePoint ACTION_PHASE = new ActionPhase();

    @Override
    public void apply(GameState gameState, PlayerState playerState) {
        playerState.addActionPhaseChoices();
    }

}
