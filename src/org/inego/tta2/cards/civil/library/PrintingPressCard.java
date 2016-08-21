package org.inego.tta2.cards.civil.library;

/**
 * Created by Inego on 21.08.2016.
 */
public class PrintingPressCard extends LibraryCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Printing Press";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 3;
    }
}
