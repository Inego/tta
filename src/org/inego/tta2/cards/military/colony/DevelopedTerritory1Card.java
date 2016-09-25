package org.inego.tta2.cards.military.colony;

import org.inego.tta2.cards.military.MilitaryCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class DevelopedTerritory1Card extends ColonyCard {

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Developed Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainSciencePoints(3);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyBlueTokens(sign);
        playerState.modifyYellowTokens(sign);
    }

}
