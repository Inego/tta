package org.inego.tta2.cards.civil.lab;

import org.inego.tta2.cards.civil.lab.LabCard;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.science.LabScienceProductionSource;

/**
 *
 */
public class PhilosophyCard extends LabCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Philosophy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 0;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyScienceProductionSource(sign, LabScienceProductionSource.PHILOSOPHY);
    }
}
