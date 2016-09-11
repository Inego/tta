package org.inego.tta2.gamestate;

/**
 * Created by Inego on 24.08.2016.
 */
public class HappinessSource {

    public static final HappinessSource ST_PETERS = new HappinessSource(1);
    public static final HappinessSource HANGING_GARDENS = new HappinessSource(2);
    public static final HappinessSource GREAT_WALL = new HappinessSource(1);
    public static final HappinessSource COMMUNISM = new HappinessSource(-1);
    public static final HappinessSource BREAD_CIRCUSES = new HappinessSource(2);
    public static final HappinessSource TEAM_SPORTS = new HappinessSource(3);
    public static final HappinessSource PRO_SPORTS = new HappinessSource(4);
    public static final HappinessSource THEOCRACY = new HappinessSource(1);
    public static final HappinessSource THEATER = new HappinessSource(1);
    public static final HappinessSource RELIGION = new HappinessSource(1);
    public static final HappinessSource THEOLOGY = new HappinessSource(2);
    public static final HappinessSource ORGANIZED_RELIGION = new HappinessSource(3);
    public static final HappinessSource EIFFEL_TOWER = new HappinessSource(1);
    public static final HappinessSource KREMLIN = new HappinessSource(-1);
    public static final HappinessSource HOMER = new HappinessSource(1);
    public static final HappinessSource HOMER_EPIC = new HappinessSource(1);


    private int baseValue;

    public HappinessSource(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getValue(PlayerState playerState) {
        return baseValue;
    }
}