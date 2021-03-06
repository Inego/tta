package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class PyramidsCard extends WonderCard {
    private static final int[] STAGES = {3, 2, 1};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Pyramids";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.modifyAdditionalCivilActions(1);
    }
}
