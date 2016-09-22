package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 *
 */
public class LibraryOfAlexandriaCard extends WonderCard {
    private static final int[] STAGES = {1, 4, 1};

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Library of Alexandria";
    }

    @Override
    public int[] getStages() {
        return STAGES;
    }

    @Override
    public void onBuild(PlayerState playerState) {
        playerState.addCultureProductionSource(CultureProductionSource.LIBRARY_OF_ALEXANDRIA);
        playerState.modifyScienceProduction(1);
        // Civil & mil. hand size + 1 -- see getHandSize method
    }
}
