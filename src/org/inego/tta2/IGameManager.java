package org.inego.tta2; /**
 *
 */

import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.exception.GameStateException;

public interface IGameManager <GS extends IGameState> {

    void run() throws GameStateException;
}
