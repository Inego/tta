package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

public class IncreasePopulationChoice extends ActionPhaseChoice {

    private int populationProductionCost;

    public IncreasePopulationChoice(int populationProductionCost) {

        this.populationProductionCost = populationProductionCost;
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
        playerState.increasePopulation(populationProductionCost);
    }
}
