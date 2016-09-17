package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 * Created by Inego on 21.08.2016.
 */
public class HangingGardensCard extends WonderCard {

    private static final int[] COST = {2, 2, 2};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Hanging Gardens";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.HANGING_GARDENS);
        playerState.addHappinessSource(WonderHappinessSource.HANGING_GARDENS);
    }
}