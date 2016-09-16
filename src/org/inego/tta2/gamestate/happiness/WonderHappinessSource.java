package org.inego.tta2.gamestate.happiness;

/**
 * Created by Inego on 11.09.2016.
 */
public class WonderHappinessSource extends HappinessSource {
    public static final WonderHappinessSource ST_PETERS = new WonderHappinessSource(1);
    public static final WonderHappinessSource HANGING_GARDENS = new WonderHappinessSource(2);
    public static final WonderHappinessSource GREAT_WALL = new WonderHappinessSource(1);
    public static final WonderHappinessSource EIFFEL_TOWER = new WonderHappinessSource(1);
    public static final WonderHappinessSource KREMLIN = new WonderHappinessSource(-1);
    public static final WonderHappinessSource HOMER_EPIC = new WonderHappinessSource(1);

    public WonderHappinessSource(int baseValue) {
        super(baseValue);
    }
}
