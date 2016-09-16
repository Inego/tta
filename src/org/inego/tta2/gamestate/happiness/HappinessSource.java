package org.inego.tta2.gamestate.happiness;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 24.08.2016.
 */
public class HappinessSource {

    public static final HappinessSource THEATER = new HappinessSource(1);
    public static final HappinessSource HOMER = new HappinessSource(1);


    private int baseValue;

    public HappinessSource(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getValue(PlayerState playerState) {
        return baseValue;
    }
}