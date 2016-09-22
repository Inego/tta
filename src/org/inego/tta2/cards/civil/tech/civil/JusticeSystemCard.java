package org.inego.tta2.cards.civil.tech.civil;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class JusticeSystemCard extends CivilTechCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Justice System";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getResearchCost() {
        return 7;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyAdditionalCivilActions(sign);
        playerState.gainBlueTokens(sign * 3);
    }
}
