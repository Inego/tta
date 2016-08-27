package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.08.2016.
 */
public class FastFoodChainsCard extends WonderCard {
    private static final int[] COST = {4, 4, 4, 4};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Fast Food Chains";
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
