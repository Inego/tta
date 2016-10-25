package org.inego.tta2.cards.military.aggression;

import org.inego.tta2.cards.military.AttackingCard;
import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.cards.military.MilitaryCardKind;

public abstract class AggressionCard extends AttackingCard {

    @Override
    public MilitaryCardKind getKind() {
        return MilitaryCardKind.AGGRESSION;
    }

}
