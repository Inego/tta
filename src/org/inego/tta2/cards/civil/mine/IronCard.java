package org.inego.tta2.cards.civil.mine;

/**
 * Created by Inego on 20.08.2016.
 */
public class IronCard extends MineCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Iron";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getBuildCost() {
        return 5;
    }

    @Override
    public int getResearchCost() {
        return 5;
    }

    @Override
    public int getProductionYield() {
        return 2;
    }
}
