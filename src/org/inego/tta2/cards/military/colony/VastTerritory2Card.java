package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

public class VastTerritory2Card extends ColonyCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Vast Territory II";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainFood(4);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyYellowTokens(sign * 4);
        playerState.modifyBlueTokens(-sign);
    }
}
