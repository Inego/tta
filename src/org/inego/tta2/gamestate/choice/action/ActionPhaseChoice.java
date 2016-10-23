package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 *
 */
public abstract class ActionPhaseChoice extends Choice {

    public abstract int getCivilActionCost();
    public abstract int getMilitaryActionCost();

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        playerState.spendMilitaryActions(getMilitaryActionCost());
        playerState.spendCivilActions(getCivilActionCost());
    }

    public static final ActionPhaseChoice END = new ActionPhaseChoice() {
        @Override
        public int getCivilActionCost() {
            return 0;
        }

        @Override
        public int getMilitaryActionCost() {
            return 0;
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.endTurn();
        }

        @Override
        public String toString() {
            return "End Action phase choice";
        }
    };

}
