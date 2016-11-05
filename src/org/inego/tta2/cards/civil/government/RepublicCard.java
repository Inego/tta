package org.inego.tta2.cards.civil.government;

public class RepublicCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Republic";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 1 : 2;
    }

    @Override
    public int getMaxCivilActions() {
        return 7;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 2;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 3;
    }

    @Override
    public int getRevolutionCost() {
        return 3;
    }

    @Override
    public int getNominalResearchCost() {
        return 13;
    }
}
