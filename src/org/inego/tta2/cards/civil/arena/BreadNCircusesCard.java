package org.inego.tta2.cards.civil.arena;

import org.inego.tta2.gamestate.happiness.ArenaHappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class BreadNCircusesCard extends ArenaCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Bread & Circuses";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 3;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(ArenaHappinessSource.BREAD_CIRCUSES, sign);
    }
}
