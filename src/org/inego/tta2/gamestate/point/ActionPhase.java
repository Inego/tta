package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 10.09.2016.
 */
public class ActionPhase extends GamePoint {

    @Override
    public void apply(GameState gameState, PlayerState playerState) {

        // TODO collect action phase choices

        playerState.addActionPhaseChoices();



    }

}
