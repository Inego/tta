package org.inego.tta2.cards.civil.temple;

/**
 * Created by Inego on 20.08.2016.
 */
public class OrganizedReligionCard extends TempleCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Organized Religion";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 7;
    }

    @Override
    public int getResearchCost() {
        return 4;
    }
}
