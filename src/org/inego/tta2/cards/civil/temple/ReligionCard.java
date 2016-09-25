package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.TempleHappinessSource;

/**
 *
 */
public class ReligionCard extends TempleCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Religion";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getNominalCost() {
        return 3;
    }

    @Override
    public int getNominalResearchCost() {
        return 0;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(TempleHappinessSource.RELIGION, sign);
    }
}
