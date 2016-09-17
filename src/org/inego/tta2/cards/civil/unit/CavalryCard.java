package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class CavalryCard extends UnitCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.CAVALRY;
    }

    @Override
    void addToComposition(Composition composition, int qty, boolean modern) {
        if (modern)
            composition.modernCavalry += qty;
        else
            composition.obsoleteCavalry += qty;
    }
}
