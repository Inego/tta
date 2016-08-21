package org.inego.tta2.cards.civil.tech.civil;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class CivilServiceCard extends CivilTechCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Civil Service";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getResearchCost() {
        return 10;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyAdditionalCivilActions(sign * 2);
        playerState.gainBlueTokens(sign * 3);
    }
}
