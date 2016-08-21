package org.inego.tta2.cards.civil.tech.military;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.tech.TechnologyCard;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class MilitaryTechCard extends TechnologyCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TECH_MILITARY;
    }
}
