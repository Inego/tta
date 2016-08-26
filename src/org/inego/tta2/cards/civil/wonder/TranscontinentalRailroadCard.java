package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 26.08.2016.
 */
public class TranscontinentalRailroadCard extends WonderCard {
    private static final int[] COST = {3, 3, 3, 3};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Transcontinental Railroad";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.modifyMilitaryStrength(4);
        playerState.setRecalcResourceProduction();
    }
}
