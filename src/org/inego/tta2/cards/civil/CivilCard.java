package org.inego.tta2.cards.civil;

import org.inego.tta2.cards.AbstractCard;
import org.inego.tta2.cards.CardType;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.PlayCardFromHandChoice;

public abstract class CivilCard extends AbstractCard {

    @Override
    public CardType getCardType() {
        return CardType.CIVIL;
    }

    public abstract CivilCardKind getKind();

    /**
     * Returns the CA points to take this card.
     *
     * @param baseCost Base cost defined by card's position in the card row (1 to 3)
     * @param playerState Player state
     * @return CA points to take the card <strong>or -1 if it may not be taken</strong>
     */
    public int getTakingCost(int baseCost, PlayerState playerState){
        return baseCost;
    }

    public abstract void generateChoices(PlayerState playerState);

    public void onTake(PlayerState playerState) {
        // Default behavior: player obtains the card in hand
        playerState.addCardToHand(this);
    }

}
