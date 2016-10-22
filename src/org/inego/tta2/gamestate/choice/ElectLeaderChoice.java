package org.inego.tta2.gamestate.choice;

import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;

/**
 *
 */
public class ElectLeaderChoice extends ActionPhaseChoice {

    public static final Choice GET_BACK_AP = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.getBackCivilAP(1);
        }
    };

    private LeaderCard leader;

    public ElectLeaderChoice(LeaderCard leader) {

        this.leader = leader;
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
        super.apply(gameState, playerState);
        playerState.electLeader(leader);
    }
}
