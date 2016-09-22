package org.inego.tta2.cards.civil.tech.military;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.tech.TechnologyCard;

/**
 *
 */
public abstract class MilitaryTechCard extends TechnologyCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TECH_MILITARY;
    }
}
