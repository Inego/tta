package org.inego.tta2.cards.civil.temple;

import org.inego.tta2.gamestate.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 20.08.2016.
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
    public int getBuildCost() {
        return 7;
    }

    @Override
    public int getResearchCost() {
        return 4;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(HappinessSource.ORGANIZED_RELIGION, sign);
    }
}
