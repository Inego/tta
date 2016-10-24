package org.inego.tta2.cards.civil.theater;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.TheaterCultureProductionSource;

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
    public int getNominalCost() {
        return 4;
    }

    @Override
    public int getNominalResearchCost() {
        return 3;
    }

    @Override
    public TheaterCultureProductionSource getCultureProductionSource() {
        return TheaterCultureProductionSource.DRAMA;
    }
}
