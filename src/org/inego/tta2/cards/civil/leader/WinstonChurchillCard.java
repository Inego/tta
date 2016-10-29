package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;

/**
 * Created by Inego on 29.10.2016.
 */
public class WinstonChurchillCard extends LeaderCard {

    public static final ActionPhaseChoice MILITARY_CHOICE = new ActionPhaseChoice() {

        @Override
        public int getCivilActionCost() {
            return 0;
        }

        @Override
        public int getMilitaryActionCost() {
            return 0;
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            super.apply(gameState, playerState);
            playerState.gainMilitaryProductionBonus(3);
            playerState.gainMilitaryScienceBonus(3);
        }
    };

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Winston Churchill";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        if (sign == 1)
            playerState.enableLeaderSpecialAction();
    }
}
