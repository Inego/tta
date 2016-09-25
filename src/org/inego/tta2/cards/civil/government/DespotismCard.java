package org.inego.tta2.cards.civil.government;

import org.inego.tta2.cards.civil.government.GovernmentCard;

/**
 *
 */
public class DespotismCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Despotism";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers;
    }

    @Override
    public int getMaxCivilActions() {
        return 4;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 2;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 2;
    }

    @Override
    public int getRevolutionCost() {
        return 0;
    }

    @Override
    public int getNominalResearchCost() {
        return 0;
    }
}
