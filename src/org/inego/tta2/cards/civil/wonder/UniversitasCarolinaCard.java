package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 25.08.2016.
 */
public class UniversitasCarolinaCard extends WonderCard {

    private static final int[] COST = {3, 3, 3};

    @Override
    public String getName() {
        return "Universitas Carolina";
    }

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.UNIVERSITAS_CAROLINA);
        playerState.modifyScienceProduction(2);
    }
}
