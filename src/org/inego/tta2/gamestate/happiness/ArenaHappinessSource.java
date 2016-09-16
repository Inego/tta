package org.inego.tta2.gamestate.happiness;

/**
 * Created by Inego on 11.09.2016.
 */
public class ArenaHappinessSource extends HappinessSource {
    public static final ArenaHappinessSource BREAD_CIRCUSES = new ArenaHappinessSource(2);
    public static final ArenaHappinessSource TEAM_SPORTS = new ArenaHappinessSource(3);
    public static final ArenaHappinessSource PRO_SPORTS = new ArenaHappinessSource(4);

    public ArenaHappinessSource(int baseValue) {
        super(baseValue);
    }
}
