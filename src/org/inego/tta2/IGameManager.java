package org.inego.tta2;

/**
 * Created by Inego on 10.09.2016.
 */

import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.exception.GameStateException;

public interface IGameManager <GS extends IGameState> {

    void run() throws GameStateException;
}
