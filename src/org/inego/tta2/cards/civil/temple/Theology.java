package org.inego.tta2.cards.civil.temple;

/**
 * Created by Inego on 20.08.2016.
 */
public class Theology extends TempleCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Theology";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 5;
    }

    @Override
    public int getResearchCost() {
        return 2;
    }
}
