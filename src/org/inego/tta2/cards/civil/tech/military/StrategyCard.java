package org.inego.tta2.cards.civil.tech.military;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class StrategyCard extends MilitaryTechCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Strategy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getNominalResearchCost() {
        return 8;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * 3);
        playerState.modifyAdditionalMilitaryActions(sign * 2);
    }
}
