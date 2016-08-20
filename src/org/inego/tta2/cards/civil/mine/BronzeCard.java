package org.inego.tta2.cards.civil.mine;

/**
 * Created by Inego on 20.08.2016.
 */
public class BronzeCard extends MineCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Bronze";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getBuildCost() {
        return 2;
    }

    @Override
    public int getResearchCost() {
        return 0;
    }

    @Override
    public int getProductionYield() {
        return 1;
    }
}
