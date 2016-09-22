package org.inego.tta2.cards.civil.tech.military;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class WarfareCard extends MilitaryTechCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Warfare";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getResearchCost() {
        return 5;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign);
        playerState.modifyAdditionalMilitaryActions(sign);
    }
}
