package org.inego.tta2.cards;

/**
 * Created by Inego on 16.08.2016.
 */
public abstract class AbstractCard implements ICard {

    @Override
    public String toString() {
        return getName();
    }
}
