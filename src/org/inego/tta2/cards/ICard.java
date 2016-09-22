package org.inego.tta2.cards;

/**
 *
 */
public interface ICard {

    CardType getCardType();

    int getAge();

    String getName();

    int getQty(int numberOfPlayers);

}
