package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.WonderCultureProductionSource;
import org.inego.tta2.gamestate.science.WonderScienceProductionSource;

/**
 *
 */
public class UniversitasCarolinaCard extends WonderCard {

    private static final int[] STAGES = {3, 3, 3};

    @Override
    public String getName() {
        return "Universitas Carolina";
    }

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(WonderCultureProductionSource.UNIVERSITAS_CAROLINA);
        playerState.addScienceProductionSource(WonderScienceProductionSource.UNIVERSITAS_CAROLINA);
    }
}
