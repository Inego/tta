package org.inego.tta2.gamestate.choice;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 28.08.2016.
 */
public abstract class Choice implements IChoice<GameState> {

    @Override
    public void apply(GameState gameState) {
        apply(gameState, gameState.getCurrentPlayerState());
    }

    protected abstract void apply(GameState gameState, PlayerState playerState);
}
