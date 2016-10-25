package org.inego.tta2.gamestate.culture;

public class LeaderCultureProductionSource extends CultureProductionSource {
    public static final LeaderCultureProductionSource JOAN_OF_ARC = new LeaderCultureProductionSource(1);
    public static final LeaderCultureProductionSource MAHATMA_GANDHI = new LeaderCultureProductionSource(2);

    public LeaderCultureProductionSource(int value) {
        super(value);
    }
}
