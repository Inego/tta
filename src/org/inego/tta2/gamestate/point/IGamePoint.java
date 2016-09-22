package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.IGameState;

/**
 *
 */
public interface IGamePoint <GS extends IGameState> {

    void apply(GS gameState);
}
