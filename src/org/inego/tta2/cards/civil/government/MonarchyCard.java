package org.inego.tta2.cards.civil.government;

/**
 *
 */
public class MonarchyCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Monarchy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getMaxCivilActions() {
        return 5;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 3;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 3;
    }

    @Override
    public int getRevolutionCost() {
        return 2;
    }

    @Override
    public int getNominalResearchCost() {
        return 8;
    }
}
