package org.inego.tta2.gamestate.happiness;

/**
 *
 */
public class LeaderHappinessSource extends HappinessSource {

    public static final LeaderHappinessSource WILLIAM_SHAKESPEARE = new LeaderHappinessSource(1);
    public static final LeaderHappinessSource CHARLIE_CHAPLIN = new LeaderHappinessSource(2);

    public LeaderHappinessSource(int baseValue) {
        super(baseValue);
    }
}
