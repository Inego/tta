package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.08.2016.
 */
public class FirstSpaceFlightCard extends WonderCard {
    private static final int[] COST = {1, 2, 4, 9};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "First Space Flight";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.setRecalcCultureProduction();
    }
}
