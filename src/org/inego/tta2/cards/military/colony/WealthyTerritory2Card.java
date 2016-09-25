package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class WealthyTerritory2Card extends ColonyCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Wealthy Territory II";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainResources(9);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyBlueTokens(sign * 4);
    }
}
