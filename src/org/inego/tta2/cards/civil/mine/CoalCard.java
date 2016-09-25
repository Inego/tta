package org.inego.tta2.cards.civil.mine;

/**
 *
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
    public int getNominalCost() {
        return 8;
    }

    @Override
    public int getNominalResearchCost() {
        return 7;
    }

    @Override
    public int getProductionYield() {
        return 3;
    }
}
