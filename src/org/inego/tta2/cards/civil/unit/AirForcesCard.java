package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 *
 */
public class AirForcesCard extends UnitCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.AIR_FORCE;
    }

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Air Forces";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getNominalResearchCost() {
        return 12;
    }

    @Override
    public int getNominalCost() {
        return 7;
    }

    @Override
    protected int getStrength() {
        return 5;
    }

    @Override
    void addToComposition(Composition composition, int qty, boolean modern) {
        // N/A
    }
}
