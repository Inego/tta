package org.inego.tta2.gamestate.happiness;

/**
 *
 */
public class TempleHappinessSource extends HappinessSource {
    public static final TempleHappinessSource RELIGION = new TempleHappinessSource(1);
    public static final TempleHappinessSource THEOLOGY = new TempleHappinessSource(2);
    public static final TempleHappinessSource ORGANIZED_RELIGION = new TempleHappinessSource(3);

    public TempleHappinessSource(int baseValue) {
        super(baseValue);
    }
}
