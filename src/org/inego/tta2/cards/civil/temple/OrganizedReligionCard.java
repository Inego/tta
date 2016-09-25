package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.happiness.TempleHappinessSource;

/**
 *
 */
public class OrganizedReligionCard extends TempleCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Organized Religion";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 7;
    }

    @Override
    public int getNominalResearchCost() {
        return 4;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(TempleHappinessSource.ORGANIZED_RELIGION, sign);
    }
}
