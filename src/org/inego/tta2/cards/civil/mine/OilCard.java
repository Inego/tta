package org.inego.tta2.cards.civil.mine;

import org.inego.tta2.cards.civil.mine.MineCard;

/**
 *
 */
public class OilCard extends MineCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Oil";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getBuildCost() {
        return 11;
    }

    @Override
    public int getResearchCost() {
        return 9;
    }

    @Override
    public int getProductionYield() {
        return 5;
    }
}
