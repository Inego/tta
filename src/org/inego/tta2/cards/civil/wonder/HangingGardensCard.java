package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.WonderCultureProductionSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 *
 */
public class HangingGardensCard extends WonderCard {

    private static final int[] STAGES = {2, 2, 2};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Hanging Gardens";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(WonderCultureProductionSource.HANGING_GARDENS);
        playerState.addHappinessSource(WonderHappinessSource.HANGING_GARDENS);
    }
}
