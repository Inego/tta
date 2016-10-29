package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.cards.civil.unit.UnitCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;

/**
 * Created by Inego on 25.09.2016.
 */
public class FrederickBarbarossaCard extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Frederick Barbarossa";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // Special action
    }

    public static class BuildUnitChoice extends ActionPhaseChoice {
        private final UnitCard unitCard;
        private final int foodCost;
        private final int buildingCost;

        public BuildUnitChoice(UnitCard unitCard, int foodCost, int buildingCost) {
            super();
            this.unitCard = unitCard;
            this.foodCost = foodCost;
            this.buildingCost = buildingCost;
        }

        @Override
        public int getCivilActionCost() {
            return 0;
        }

        @Override
        public int getMilitaryActionCost() {
            return 1;
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            super.apply(gameState, playerState);
            playerState.payFood(foodCost);
            playerState.payResourcesForMilitary(buildingCost);
            playerState.build(unitCard);
        }
    }
}
