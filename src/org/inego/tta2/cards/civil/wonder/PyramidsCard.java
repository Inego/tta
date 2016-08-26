package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class PyramidsCard extends WonderCard {
    private static final int[] COST = {3, 2, 1};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Pyramids";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.modifyAdditionalCivilActions(1);
    }
}
