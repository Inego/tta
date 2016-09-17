package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class InfantryCard extends UnitCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.INFANTRY;
    }

    @Override
    void addToComposition(Composition composition, int qty, boolean modern) {
        if (modern)
            composition.modernInfantry += qty;
        else
            composition.obsoleteInfantry += qty;
    }
}
