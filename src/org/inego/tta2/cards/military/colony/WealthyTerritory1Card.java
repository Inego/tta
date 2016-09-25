package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class WealthyTerritory1Card extends ColonyCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Wealthy Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainResources(5);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyBlueTokens(sign * 3);
    }
}
