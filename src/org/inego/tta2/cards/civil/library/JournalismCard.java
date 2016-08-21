package org.inego.tta2.cards.civil.library;

/**
 * Created by Inego on 21.08.2016.
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
        return numberOfPlayers == 1 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 6;
    }
}