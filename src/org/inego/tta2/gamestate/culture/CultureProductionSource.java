package org.inego.tta2.gamestate.culture;

/**
 *
 */
public abstract class CultureProductionSource {


    private int value;

    public CultureProductionSource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
