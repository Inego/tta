package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.08.2016.
 */
public class InternetCard extends WonderCard {
    private static final int[] STAGES = {2, 3, 4, 3, 2};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Internet";
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
