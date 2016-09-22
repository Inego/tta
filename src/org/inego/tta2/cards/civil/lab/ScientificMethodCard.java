package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.LabScienceProductionSource;

/**
 *
 */
public class ScientificMethodCard extends LabCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Scientific Method";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 6;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, LabScienceProductionSource.SCIENTIFIC_METHOD);
    }
}
