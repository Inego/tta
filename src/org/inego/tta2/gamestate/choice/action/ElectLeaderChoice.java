package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;

/**
 *
 */
public class ElectLeaderChoice extends PlayCardFromHandChoice<LeaderCard> {

    public static final Choice GET_BACK_AP = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.getBackCivilAP(1);
        }
    };

    public ElectLeaderChoice(LeaderCard cardToPlay) {
        super(cardToPlay);
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
        playerState.electLeader(getCardToPlay());
    }
}
