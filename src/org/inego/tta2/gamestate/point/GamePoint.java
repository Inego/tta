package org.inego.tta2.gamestate.point;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 28.08.2016.
 */
public abstract class GamePoint implements IGamePoint<GameState> {

    public static final GamePoint POLITICAL_PHASE = new PoliticalPhase();
    public static final GamePoint ACTION_PHASE = new ActionPhase();

    public static final GamePoint HOMER_REPLACED = new HomerReplaced();

    public static final GamePoint START_TURN = new StartTurn();

    @Override
    public final void apply(GameState gameState) {
        apply(gameState, gameState.getCurrentPlayerState());
    }

    public abstract void apply(GameState gameState, PlayerState playerState);
}
