package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;

/**
 * Created by Inego on 28.08.2016.
 */
public abstract class GamePoint implements IGamePoint<GameState> {

    public static final GamePoint POLITICAL_PHASE = new PoliticalPhase();
    public static final GamePoint ACTION_PHASE = new ActionPhase();

    public static final GamePoint USE_JULIUS_CAESAR_ACTION = new JuliusCaesarAction();
    public static final GamePoint HOMER_REPLACED = new HomerReplaced();


    public static final GamePoint START_TURN = new StartTurn();
}
