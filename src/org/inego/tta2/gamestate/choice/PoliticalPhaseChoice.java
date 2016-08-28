package org.inego.tta2.gamestate.choice;

import org.inego.tta2.gamestate.*;

/**
 * Created by Inego on 28.08.2016.
 */
public abstract class PoliticalPhaseChoice extends Choice {

    private static final Choice JC_PASS = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            gameState.startActionPhase();
        }
    };

    private static final Choice JC_USE = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.useJuliusCaesarAction();
        }
    };

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        if (playerState.isJuliusCaesarSpecialActionAvailable()) {
            gameState.proceedTo(GamePoint.USE_JULIUS_CAESAR_ACTION, JC_PASS, JC_USE);
        }
    }

}
