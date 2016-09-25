package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.TheaterCultureProductionSource;

/**
 *
 */
public class MoviesCard extends TheaterCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Movies";
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
        return 10;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, TheaterCultureProductionSource.MOVIES);
    }
}
