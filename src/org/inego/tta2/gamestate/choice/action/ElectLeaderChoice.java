package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

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
    protected void apply(GameState gameState, PlayerState playerState) {
        super.apply(gameState, playerState);
        playerState.electLeader(getCard());
    }
}
