package org.inego.tta2.cards.civil;

import org.inego.tta2.cards.AbstractCard;
import org.inego.tta2.cards.CardType;

/**
 * Created by Inego on 16.08.2016.
 */
public abstract class CivilCard extends AbstractCard {

    public static final CivilCard AGRICULTURE = new AgricultureCard();

    @Override
    public CardType getCardType() {
        return CardType.CIVIL;
    }

    public abstract CivilCardKind getCivilCardKind();

}
