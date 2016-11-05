package org.inego.tta2.cards.civil;

public class CardInHand {
    public CivilCard card;
    public boolean takenThisTurn;

    public CardInHand(CivilCard card) {
        this.card = card;
        takenThisTurn = true;
    }
}
