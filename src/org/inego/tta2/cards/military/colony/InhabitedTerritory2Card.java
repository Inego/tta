package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class InhabitedTerritory2Card extends ColonyCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Inhabited Territory II";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainPopulation(2);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.gainYellowTokens(sign * 3);
    }
}
