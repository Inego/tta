package org.inego.tta2.cards.civil.tech.military;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class MilitaryTheoryCard extends MilitaryTechCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Military Theory";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 1 : 2;
    }

    @Override
    public int getResearchCost() {
        return 11;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * 5);
        playerState.modifyAdditionalMilitaryActions(sign * 3);
    }
}
