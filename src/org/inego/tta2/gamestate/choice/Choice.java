package org.inego.tta2.gamestate.choice;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.IGameState;

/**
 * Created by Inego on 28.08.2016.
 */
public abstract class Choice implements IChoice {

    @Override
    public void apply(IGameState gameState) {
        apply((GameState) gameState);
    }

    protected abstract void apply(GameState gameState);
}
