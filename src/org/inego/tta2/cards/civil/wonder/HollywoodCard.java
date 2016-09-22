package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class HollywoodCard extends WonderCard {

    private static final int[] STAGES = {5, 6, 5};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Hollywood";
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
