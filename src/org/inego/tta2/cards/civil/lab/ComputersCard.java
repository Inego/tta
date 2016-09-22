package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.LabScienceProductionSource;

/**
 *
 */
public class ComputersCard extends LabCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Computers";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 11;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, LabScienceProductionSource.COMPUTERS);
    }

    @Override
    public int getResearchCost() {
        return 8;
    }


}
