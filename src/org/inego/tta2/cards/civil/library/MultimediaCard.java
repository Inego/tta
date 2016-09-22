package org.inego.tta2.cards.civil.library;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.science.LibraryScienceProductionSource;

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
    public int getBuildCost() {
        return 11;
    }

    @Override
    public int getResearchCost() {
        return 9;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyCultureProductionSource(sign, LibraryCultureProductionSource.MULTIMEDIA);
        playerState.modifyScienceProductionSource(sign, LibraryScienceProductionSource.MULTIMEDIA);
    }
}
