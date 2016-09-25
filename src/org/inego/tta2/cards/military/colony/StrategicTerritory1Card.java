package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class StrategicTerritory1Card extends ColonyCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Strategic Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.drawMilitaryCards(3);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * 2);
    }
}
