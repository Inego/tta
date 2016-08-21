package org.inego.tta2.cards.civil.government;

/**
 * Created by Inego on 21.08.2016.
 */
public class ConstitutionalMonarchy extends GovernmentCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Constitutional Monarchy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }

    @Override
    public int getMaxCivilActions() {
        return 6;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 4;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 3;
    }

    @Override
    public int getRevolutionCost() {
        return 6;
    }

    @Override
    public int getFullCost() {
        return 12;
    }
}
