package org.inego.tta2.cards.civil.mine;

/**
 *
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
    public int getNominalCost() {
        return 5;
    }

    @Override
    public int getNominalResearchCost() {
        return 5;
    }

    @Override
    public int getProductionYield() {
        return 2;
    }
}
