package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.PlayCardFromHandChoice;

/**
 * A trivial action with one choice
 */
public abstract class SimpleActionCard extends ActionCard {

    protected abstract void performAction(PlayerState playerState);

    @Override
    public final void generateChoices(PlayerState playerState) {
        playerState.addChoice(new SimpleActionCardChoice(this));
    }

    public static class SimpleActionCardChoice extends PlayCardFromHandChoice<SimpleActionCard> {

        public SimpleActionCardChoice(SimpleActionCard cardToPlay) {
            super(cardToPlay);
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            super.apply(gameState, playerState);
            getCard().performAction(playerState);
        }
    }

}
