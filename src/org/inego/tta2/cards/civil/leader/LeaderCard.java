package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;

/**
 * Created by Inego on 20.08.2016.
 */
public abstract class LeaderCard extends CivilCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public CivilCardKind getCivilCardKind() {
        return CivilCardKind.LEADER;
    }
}
