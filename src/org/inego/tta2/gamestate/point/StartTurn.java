package org.inego.tta2.gamestate.point;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class StartTurn extends GamePoint {

    public static final GamePoint INSTANCE = new StartTurn();

    @Override
    public void apply(GameState gameState, PlayerState playerState) {

        boolean normal = gameState.getAge() > 0;

        if (normal) {
            gameState.replenishCardRow();
        }

        playerState.resolveWar();
        playerState.makeCurrentTacticsAvailable();

        // Some leaders restore their special action every turn
        if (playerState.getLeader() == Cards.HAMMURABI
                || playerState.getLeader() == Cards.JS_BACH
                || playerState.getLeader() == Cards.WINSTON_CHURCHILL) {
            playerState.enableLeaderSpecialAction();
        }

        gameState.proceedTo(normal ? PoliticalPhase.INSTANCE : ActionPhase.INSTANCE);

    }
}
