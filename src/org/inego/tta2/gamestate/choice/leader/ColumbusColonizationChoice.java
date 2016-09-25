package org.inego.tta2.gamestate.choice.leader;

import org.inego.tta2.cards.military.colony.ColonyCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

public class ColumbusColonizationChoice extends Choice {

    private ColonyCard colony;

    public ColumbusColonizationChoice(ColonyCard colony) {
        this.colony = colony;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {

        // Colonize for free
        playerState.colonize(colony);

        // Columbus leaves
        playerState.removeCurrentLeader();

    }
}
