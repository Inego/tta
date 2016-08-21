package org.inego.tta2.cards.civil.government;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;

/**
 * Created by Inego on 18.08.2016.
 */
public abstract class GovernmentCard extends CivilCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.GOVERNMENT;
    }

    public abstract int getMaxCivilActions();
    public abstract int getMaxMilitaryActions();
    public abstract int getUrbanBuildingLimit();
}
