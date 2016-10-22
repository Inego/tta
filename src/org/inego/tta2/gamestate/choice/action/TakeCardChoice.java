package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class TakeCardChoice extends ActionPhaseChoice {

    private final int idx;

    private int apCost;

    public TakeCardChoice(GameState gameState, PlayerState playerState, int idx) {
        this.idx = idx;

        if (idx < 5)
            apCost = 1;
        else if (idx < 8)
            apCost = 2;
        else apCost = 3;

        CivilCard civilCard = gameState.peekCardRow(idx);

        apCost = civilCard.getTakingCost(apCost, playerState);

    }

    @Override
    public int getCivilActionCost() {
        return apCost;
    }

    @Override
    public int getMilitaryActionCost() {
        return 0;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        super.apply(gameState, playerState);
        CivilCard takenCard = gameState.getCardFromRow(idx);
        playerState.addCardToHand(takenCard);
    }
}
