package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class CavalryCard extends UnitCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.CAVALRY;
    }
}
