package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 21.08.2016.
 */
public class DramaCard extends TheaterCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Drama";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 4;
    }

    @Override
    public int getResearchCost() {
        return 3;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyCultureProductionSource(sign, CultureProductionSource.DRAMA);
    }
}
