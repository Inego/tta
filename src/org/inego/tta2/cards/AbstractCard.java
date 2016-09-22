package org.inego.tta2.cards;

/**
 *
 */
public abstract class AbstractCard implements ICard {

    @Override
    public String toString() {
        return getName();
    }
}
