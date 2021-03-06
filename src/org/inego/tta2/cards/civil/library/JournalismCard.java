package org.inego.tta2.cards.civil.library;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.science.IScienceProductionSource;

/**
 *
 */
public class JournalismCard extends LibraryCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Journalism";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getNominalCost() {
        return 8;
    }

    @Override
    public int getNominalResearchCost() {
        return 6;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, LibraryCultureProductionSource.JOURNALISM);
    }

    @Override
    public int getScienceProductionValue() {
        return 2;
    }
}
