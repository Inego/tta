package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.IGameState;

/**
 * Created by Inego on 28.08.2016.
 */
public interface IChoice <GS extends IGameState> {

    void apply(GS gameState);



}