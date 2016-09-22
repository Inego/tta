package org.inego.tta2.gamestate.happiness;

/**
 *
 */
public class GovernmentHappinessSource extends HappinessSource {
    public static final GovernmentHappinessSource COMMUNISM = new GovernmentHappinessSource(-1);
    public static final GovernmentHappinessSource THEOCRACY = new GovernmentHappinessSource(1);

    public GovernmentHappinessSource(int baseValue) {
        super(baseValue);
    }
}
