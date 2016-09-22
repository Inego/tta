package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 *
 */
public class JoanOfArcCard extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Joan of Arc";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyAdditionalMilitaryActions(sign);
        playerState.modifyCultureProductionSource(sign, CultureProductionSource.JOAN_OF_ARC);
        playerState.setRecalcMilitaryStrength();
    }
}
