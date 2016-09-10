package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 10.09.2016.
 */
public class StartTurn extends GamePoint {

    @Override
    public void apply(GameState gameState) {

        if (gameState.getAge() > 0) {
            gameState.replenishCardRow();
        }

        PlayerState playerState = gameState.getCurrentPlayerState();
        playerState.resolveWar();
        playerState.makeCurrentTacticsAvailable();



    }
}
