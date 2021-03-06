package org.inego.tta2.cards.civil.library;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class PrintingPressCard extends LibraryCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Printing Press";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 3;
    }

    @Override
    public int getNominalResearchCost() {
        return 3;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, LibraryCultureProductionSource.PRINTING_PRESS);
    }

    @Override
    public int getScienceProductionValue() {
        return 1;
    }
}
