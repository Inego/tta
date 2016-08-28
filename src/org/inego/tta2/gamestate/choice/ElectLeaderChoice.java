package org.inego.tta2.gamestate.choice;

import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 28.08.2016.
 */
public class ElectLeaderChoice extends ActionPhaseChoice {

    private LeaderCard leader;

    public ElectLeaderChoice(LeaderCard leader) {

        this.leader = leader;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {

        playerState.electLeader(leader);

    }
}
