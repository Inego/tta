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

        if (gameState.getAge() > 0) {
            gameState.replenishCardRow();
        }

        playerState.resolveWar();
        playerState.makeCurrentTacticsAvailable();

        // Hammurabi restores his special action every turn
        if (playerState.getLeader() == Cards.HAMMURABI) {
            playerState.enableLeaderSpecialAction();
        }

        gameState.proceedTo(PoliticalPhase.POLITICAL_PHASE);

    }
}
