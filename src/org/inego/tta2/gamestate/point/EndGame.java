package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public class EndGame extends GamePoint {

    public static final org.inego.tta2.gamestate.point.GamePoint INSTANCE = new EndGame();

    @Override
    public void apply(GameState gameState, PlayerState playerState) {

        // TODO transit to EndGame point from endgame conditions

        gameState.onEndGame();

    }
}
