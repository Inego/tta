package org.inego.tta2.gamestate.choice.political;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.leader.JuliusCaesarCard;
import org.inego.tta2.gamestate.*;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.point.ActionPhase;

/**
 *
 */
public abstract class PoliticalPhaseChoice extends Choice {

    public static final PoliticalPhaseChoice PASS = new PoliticalPhaseChoice() {

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            gameState.proceedTo(ActionPhase.INSTANCE);
        }
    };

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
        // TODO Test Julius Caesar special action
        if (playerState.getLeader() == Cards.JULIUS_CAESAR && playerState.isLeaderSpecialActionAvailable()) {
            gameState.proceedTo(JuliusCaesarCard.POINT, JC_PASS, JC_USE);
        }
    }

}
