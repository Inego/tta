package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

public class VastTerritory1Card extends ColonyCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Vast Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainFood(3);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyYellowTokens(sign * 3);
        playerState.modifyBlueTokens(-sign);
    }
}
