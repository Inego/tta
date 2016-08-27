package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 26.08.2016.
 */
public class KremlinCard extends WonderCard {
    private static final int[] COST = {4, 4, 4};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Kremlin";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.KREMLIN);
        playerState.modifyAdditionalCivilActions(1);
        playerState.modifyAdditionalMilitaryActions(1);
        playerState.addHappinessSource(HappinessSource.KREMLIN);
    }
}
