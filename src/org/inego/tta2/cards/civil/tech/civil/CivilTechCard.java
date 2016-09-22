package org.inego.tta2.cards.civil.tech.civil;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.tech.TechnologyCard;

/**
 *
 */
public abstract class CivilTechCard extends TechnologyCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TECH_CIVIL;
    }
}
