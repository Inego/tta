package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class DevelopedTerritory2Card extends ColonyCard {

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Developed Territory II";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainSciencePoints(5);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyBlueTokens(sign * 2);
        playerState.modifyYellowTokens(sign * 2);
    }

}
