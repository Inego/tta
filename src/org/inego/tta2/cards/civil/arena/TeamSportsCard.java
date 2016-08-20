package org.inego.tta2.cards.civil.arena;

/**
 * Created by Inego on 20.08.2016.
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
    public int getBuildCost() {
        return 5;
    }

    @Override
    public int getResearchCost() {
        return 5;
    }
}
