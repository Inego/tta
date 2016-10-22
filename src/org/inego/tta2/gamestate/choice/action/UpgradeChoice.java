package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.upgrade.UpgradeDescription;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 * Created by Inego on 15.10.2016.
 */
public class UpgradeChoice extends ActionPhaseChoice {

    public BuildingCard from;
    public BuildingCard to;
    public int cost;

    public UpgradeChoice(UpgradeDescription availableUpgrade) {
        from = availableUpgrade.source;
        to   = availableUpgrade.destination;
        cost = availableUpgrade.delta;
    }

    public UpgradeChoice(BuildingCard from, BuildingCard to, int cost) {
        this.from = from;
        this.to   = to;
        this.cost = cost;
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
        playerState.disband(from);
        playerState.build(to);
        playerState.payResources(cost);
    }

}
