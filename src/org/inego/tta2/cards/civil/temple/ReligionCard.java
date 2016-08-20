package org.inego.tta2.cards.civil.temple;

/**
 * Created by Inego on 20.08.2016.
 */
public class ReligionCard extends TempleCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Religion";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getBuildCost() {
        return 3;
    }

    @Override
    public int getResearchCost() {
        return 0;
    }
}
