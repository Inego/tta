package org.inego.tta2.cards.military;

import org.inego.tta2.cards.AbstractCard;
import org.inego.tta2.cards.CardType;

/**
 * Created by Inego on 16.08.2016.
 */
public abstract class MilitaryCard extends AbstractCard {
    @Override
    public CardType getCardType() {
        return CardType.MILITARY;
    }

    public abstract MilitaryCardKind getKind();
}
