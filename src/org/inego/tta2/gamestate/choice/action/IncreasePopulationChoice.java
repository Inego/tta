package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 * Created by Inego on 10.09.2016.
 */
public class IncreasePopulationChoice extends Choice {

    private int populationProductionCost;

    public IncreasePopulationChoice(int populationProductionCost) {

        this.populationProductionCost = populationProductionCost;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        playerState.increasePopulation(populationProductionCost);
    }
}
