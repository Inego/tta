package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 25.08.2016.
 */
public class TajMahalCard extends WonderCard {

    private static final int[] COST = {2, 4, 2};

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Taj Mahal";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.TAJ_MAHAL);
        playerState.gainBlueTokens(1);
    }

    @Override
    public int getTakingCost(int baseCost, PlayerState playerState) {
        int result = baseCost;
        if (playerState.wasLeaderReplaced()) result -= 2;
        if (result < 0) result = 0;
        return result;
    }
}
