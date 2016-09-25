package org.inego.tta2.cards.civil.mine;

/**
 *
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
    public int getNominalCost() {
        return 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 0;
    }

    @Override
    public int getProductionYield() {
        return 1;
    }
}
