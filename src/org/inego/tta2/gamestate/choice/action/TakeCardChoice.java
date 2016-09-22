package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class TakeCardChoice extends ActionPhaseChoice {

    private final int idx;

    public TakeCardChoice(int idx) {
        this.idx = idx;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        CivilCard takenCard = gameState.getCardFromRow(idx);
        playerState.addCardToHand(takenCard);
    }
}
