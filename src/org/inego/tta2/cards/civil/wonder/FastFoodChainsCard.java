package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class FastFoodChainsCard extends WonderCard {
    private static final int[] STAGES = {4, 4, 4, 4};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Fast Food Chains";
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
