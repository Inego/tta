package org.inego.tta2.cards.civil.government;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 18.08.2016.
 */
public abstract class GovernmentCard extends CivilCard implements ITechnologyCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.GOVERNMENT;
    }

    public abstract int getMaxCivilActions();
    public abstract int getMaxMilitaryActions();
    public abstract int getUrbanBuildingLimit();
    public abstract int getRevolutionCost();

    public void apply(int sign, PlayerState playerState) {
        // Default: do nothing
    }

}
