package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 * Created by Inego on 26.08.2016.
 */
public class EiffelTowerCard extends WonderCard {
    private static final int[] COST = {3, 7, 3};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Eiffel Tower";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.EIFFEL_TOWER);
        playerState.addHappinessSource(WonderHappinessSource.EIFFEL_TOWER);
    }
}
