package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public abstract class GamePoint implements IGamePoint<GameState> {

    @Override
    public final void apply(GameState gameState) {
        apply(gameState, gameState.getCurrentPlayerState());
    }

    public abstract void apply(GameState gameState, PlayerState playerState);
}
