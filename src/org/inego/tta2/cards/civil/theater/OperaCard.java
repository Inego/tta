package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.TheaterCultureProductionSource;

/**
 *
 */
public class OperaCard extends TheaterCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Theater";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getNominalCost() {
        return 8;
    }

    @Override
    public int getNominalResearchCost() {
        return 7;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, TheaterCultureProductionSource.OPERA);
    }
}
