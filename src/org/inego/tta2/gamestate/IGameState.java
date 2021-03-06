package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.exception.GameStateException;
import org.inego.tta2.gamestate.point.IGamePoint;

import java.util.List;
import java.util.Stack;

/**
 *
 */
public interface IGameState {

    // If the stack is empty, the game is finished
    Stack<? extends IGamePoint> getPointStack();

    /**
     * Returns the list of events that have passed since last choice.
     */
    List<IGameEvent> getLastEvents();

    int getCurrentPlayer();

    List<? extends IChoice> getChoices();

    int getNumberOfPlayers();

    void next(int choiceIdx) throws GameStateException;

}
