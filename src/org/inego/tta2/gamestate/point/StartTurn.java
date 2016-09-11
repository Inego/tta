package org.inego.tta2.gamestate.point;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 10.09.2016.
 */
public class StartTurn extends GamePoint {

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

        gameState.proceedTo(POLITICAL_PHASE);

    }
}
