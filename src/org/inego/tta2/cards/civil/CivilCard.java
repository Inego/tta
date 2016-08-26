package org.inego.tta2.cards.civil;

import org.inego.tta2.cards.AbstractCard;
import org.inego.tta2.cards.CardType;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 16.08.2016.
 */
public abstract class CivilCard extends AbstractCard {

    @Override
    public CardType getCardType() {
        return CardType.CIVIL;
    }

    public abstract CivilCardKind getKind();

    public int getTakingCost(int baseCost, PlayerState playerState){
        return baseCost;
    }

}
