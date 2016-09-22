package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class FirstSpaceFlightCard extends WonderCard {
    private static final int[] STAGES = {1, 2, 4, 9};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "First Space Flight";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.setRecalcCultureProduction();
    }
}
