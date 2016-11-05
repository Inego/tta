package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public class PlayCardFromHandChoice<T extends CivilCard> extends ActionPhaseChoice {

    private T cardToPlay;

    public PlayCardFromHandChoice(T cardToPlay) {
        this.cardToPlay = cardToPlay;
    }

    public T getCardToPlay() {
        return cardToPlay;
    }

    @Override
    public int getCivilActionCost() {
        return 1;
    }

    @Override
    public int getMilitaryActionCost() {
        return 0;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        super.apply(gameState, playerState); // To pay action points
        playerState.removeFromHand(cardToPlay);
    }
}
