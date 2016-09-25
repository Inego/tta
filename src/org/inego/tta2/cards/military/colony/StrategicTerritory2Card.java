package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

public class StrategicTerritory2Card extends ColonyCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Strategic Territory II";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.drawMilitaryCards(5);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * 4);
    }
}
