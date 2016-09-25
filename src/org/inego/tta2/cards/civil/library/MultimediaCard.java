package org.inego.tta2.cards.civil.library;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class MultimediaCard extends LibraryCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Multimedia";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 11;
    }

    @Override
    public int getNominalResearchCost() {
        return 9;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, LibraryCultureProductionSource.MULTIMEDIA);
    }

    @Override
    public int getScienceProductionValue() {
        return 3;
    }
}
