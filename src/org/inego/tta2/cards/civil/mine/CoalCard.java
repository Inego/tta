package org.inego.tta2.cards.civil.mine;

/**
 * Created by Inego on 20.08.2016.
 */
public class CoalCard extends MineCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Coal";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 7;
    }

    @Override
    public int getProductionYield() {
        return 3;
    }
}
