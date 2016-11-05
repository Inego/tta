package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

public class TranscontinentalRailroadCard extends WonderCard {
    private static final int[] STAGES = {3, 3, 3, 3};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Transcontinental Railroad";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(4);
        playerState.setRecalcResourceProduction();
    }
}
