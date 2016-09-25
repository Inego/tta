package org.inego.tta2.cards.military.colony;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.ColonyHappinessSource;
import org.inego.tta2.gamestate.happiness.HappinessSource;

/**
 *
 */
public class HistoricTerritory1Card extends ColonyCard {
    private static final HappinessSource HAPPINESS_SOURCE = new ColonyHappinessSource(1);

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Historic Territory I";
    }

    @Override
    public void immediateBonus(PlayerState playerState) {
        playerState.gainCulturePoints(6);
    }

    @Override
    public void onGain(int sign, PlayerState playerState) {
        playerState.modifyHappinessSource(HAPPINESS_SOURCE, sign);
    }
}
