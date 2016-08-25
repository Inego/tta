package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 21.08.2016.
 */
public class GreatWallCard extends WonderCard {
    private static final int[] COST = {2, 2, 3, 2};

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Great Wall";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.modifyCultureProduction(1);
        playerState.addHappinessSource(HappinessSource.GREAT_WALL);
        // Military bonus calculated in getMilitaryStrength().
    }
}
