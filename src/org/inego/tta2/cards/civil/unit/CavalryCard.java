package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 *
 */
public abstract class CavalryCard extends UnitCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.CAVALRY;
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.CAVALRY;
    }

    @Override
    void addToComposition(Composition composition, int qty, boolean modern) {
        if (modern)
            composition.modernCavalry += qty;
        else
            composition.obsoleteCavalry += qty;
    }
}
