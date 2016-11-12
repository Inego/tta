package org.inego.tta2.cards;

public abstract class AbstractCard implements ICard {

    public static final String[] AGE_STRINGS = new String[] {
            "A",
            "I",
            "II",
            "III",
            "IV"
    };

    @Override
    public String toString() {
        return getName();
    }

    protected final String nameWithAge(String baseName)
    {
        return baseName + " " + AGE_STRINGS[getAge()];
    }

}
