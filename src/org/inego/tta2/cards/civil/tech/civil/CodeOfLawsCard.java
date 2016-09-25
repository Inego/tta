package org.inego.tta2.cards.civil.tech.civil;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class CodeOfLawsCard extends CivilTechCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Code of Laws";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 6;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyAdditionalCivilActions(sign);
    }
}
