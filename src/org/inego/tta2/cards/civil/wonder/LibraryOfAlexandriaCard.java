package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 21.08.2016.
 */
public class LibraryOfAlexandriaCard extends WonderCard {
    private static final int[] COST = {1, 4, 1};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Library of Alexandria";
    }

    @Override
    public int[] getBuildingCost() {
        return COST;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.LIBRARY_OF_ALEXANDRIA);
        playerState.modifyScienceProduction(1);
        // Civil & mil. hand size + 1 -- see getHandSize method
    }
}
