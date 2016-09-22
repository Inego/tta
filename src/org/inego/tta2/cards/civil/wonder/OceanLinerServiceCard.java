package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class OceanLinerServiceCard extends WonderCard {
    private static final int[] STAGES = {4, 2, 2, 4};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Ocean Liner Service";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        // TODO Ocean liner service free pop special action
    }
}
