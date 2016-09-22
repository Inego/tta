package org.inego.tta2.gamestate.culture;

/**
 *
 */
public class GovernmentCultureProductionSource extends CultureProductionSource {

    public static final GovernmentCultureProductionSource THEOCRACY = new GovernmentCultureProductionSource(1);
    public static final GovernmentCultureProductionSource DEMOCRACY = new GovernmentCultureProductionSource(3);

    public GovernmentCultureProductionSource(int value) {
        super(value);
    }
}
