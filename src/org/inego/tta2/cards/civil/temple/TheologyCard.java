package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.TempleHappinessSource;

/**
 *
 */
public class TheologyCard extends TempleCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Theology";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 5;
    }

    @Override
    public int getResearchCost() {
        return 2;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(TempleHappinessSource.THEOLOGY, sign);
    }
}
