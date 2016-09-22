package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.WonderCultureProductionSource;

/**
 *
 */
public class TajMahalCard extends WonderCard {

    private static final int[] STAGES = {2, 4, 2};

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Taj Mahal";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(WonderCultureProductionSource.TAJ_MAHAL);
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
