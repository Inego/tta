package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.exception.GameStateException;

import java.util.List;

/**
 * Created by Inego on 16.08.2016.
 */
public interface IGameState {

    IGamePoint getPoint();

    int getCurrentPlayer();

    List<? extends IChoice> getChoices();

    int getNumberOfPlayers();

    void next(int choiceIdx) throws GameStateException;

}
