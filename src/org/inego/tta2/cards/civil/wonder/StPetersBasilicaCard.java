package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

import static org.inego.tta2.gamestate.happiness.WonderHappinessSource.ST_PETERS;

/**
 * Created by Inego on 21.08.2016.
 */
public class StPetersBasilicaCard extends WonderCard {
    private static final int[] COST = {4, 4};

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "St. Peter's Basilica";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.ST_PETERS);
        playerState.addHappinessSource(ST_PETERS);
    }




}
