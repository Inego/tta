package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.IGameState;

/**
 *
 */
public interface IChoice <GS extends IGameState> {

    void apply(GS gameState);



}
