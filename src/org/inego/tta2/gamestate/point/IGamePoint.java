package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.IGameState;

/**
 * Created by Inego on 28.08.2016.
 */
public interface IGamePoint <GS extends IGameState> {

    void apply(GS gameState);
}
