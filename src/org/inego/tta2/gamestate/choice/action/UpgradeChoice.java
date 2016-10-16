package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.upgrade.UpgradeDescription;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 * Created by Inego on 15.10.2016.
 */
public class UpgradeChoice extends Choice {

    public BuildingCard from;
    public BuildingCard to;
    public int cost;

    public UpgradeChoice(UpgradeDescription availableUpgrade) {
        super();
        from = availableUpgrade.source;
        to = availableUpgrade.destination;
        cost = availableUpgrade.delta;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        playerState.disband(from);
        playerState.build(to);
        playerState.payResources(cost);
    }

}
