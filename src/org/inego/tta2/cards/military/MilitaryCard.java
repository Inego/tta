package org.inego.tta2.cards.military;

import org.inego.tta2.cards.AbstractCard;
import org.inego.tta2.cards.CardType;

public abstract class MilitaryCard extends AbstractCard {
    @Override
    public final CardType getCardType() {
        return CardType.MILITARY;
    }

    public abstract MilitaryCardKind getKind();
}
