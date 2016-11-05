package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public class TakeCardChoice extends ActionPhaseChoice {

    private final int idx;

    private int apCost;

    public TakeCardChoice(int idx, int apCost) {
        this.idx = idx;
        this.apCost = apCost;
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
        takenCard.onTake(playerState);
    }

    public int getIdx() {
        return idx;
    }
}
