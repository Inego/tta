package org.inego.tta2.cards.civil.arena;

import org.inego.tta2.gamestate.happiness.ArenaHappinessSource;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public class TeamSportsCard extends ArenaCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Team Sports";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getNominalCost() {
        return 5;
    }

    @Override
    public int getNominalResearchCost() {
        return 5;
    }

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        super.assignWorker(sign, playerState);
        playerState.modifyHappinessSource(ArenaHappinessSource.TEAM_SPORTS, sign);
    }
}
