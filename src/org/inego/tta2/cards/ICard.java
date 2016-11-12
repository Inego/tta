package org.inego.tta2.cards;

public interface ICard {

    CardType getCardType();

    /**
     * Returns the age of the card as a number (0..3).
     *
     * @return Age of the card as a number
     */
    int getAge();

    String getName();

    /**
     * Returns the quantity of this card depending on the number of players in a game.
     * @param numberOfPlayers Number of players in a game
     * @return Quantity
     */
    int getQty(int numberOfPlayers);

}
