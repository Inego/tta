package org.inego.tta2.player;

import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.IGameState;

import java.util.List;

/**
 * Created by Inego on 10.09.2016.
 */
public interface IPlayer {


    int choose(IGameState gameState, List<? extends IChoice> choices);
}
