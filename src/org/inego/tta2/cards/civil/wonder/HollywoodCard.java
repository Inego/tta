package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.08.2016.
 */
public class HollywoodCard extends WonderCard {

    private static final int[] COST = {5, 6, 5};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Hollywood";
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
