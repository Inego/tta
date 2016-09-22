package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 *
 */
public class EiffelTowerCard extends WonderCard {
    private static final int[] STAGES = {3, 7, 3};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Eiffel Tower";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.EIFFEL_TOWER);
        playerState.addHappinessSource(WonderHappinessSource.EIFFEL_TOWER);
    }
}
