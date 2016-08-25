package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;

import static org.inego.tta2.gamestate.HappinessSource.ST_PETERS;

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
        playerState.modifyCultureProduction(2);
        playerState.addHappinessSource(ST_PETERS);
        // Happiness bonus - see recalcHappiness
        playerState.setRecalcHappiness();

        // TODO - on destroy setRecalcHappiness?
    }




}
