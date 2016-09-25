package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class InhabitedTerritory1Card extends ColonyCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Inhabited Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainPopulation(1);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.gainYellowTokens(sign * 2);
    }
}
