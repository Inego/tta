package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 *
 */
public class KremlinCard extends WonderCard {
    private static final int[] STAGES = {4, 4, 4};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Kremlin";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.KREMLIN);
        playerState.modifyAdditionalCivilActions(1);
        playerState.modifyAdditionalMilitaryActions(1);
        playerState.addHappinessSource(WonderHappinessSource.KREMLIN);
    }
}
