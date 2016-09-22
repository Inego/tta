package org.inego.tta2.gamestate.culture;

/**
 *
 */
public class TheaterCultureProductionSource extends BuildingCultureProductionSource {
    public static final TheaterCultureProductionSource DRAMA = new TheaterCultureProductionSource(2);
    public static final TheaterCultureProductionSource OPERA = new TheaterCultureProductionSource(3);
    public static final TheaterCultureProductionSource MOVIES = new TheaterCultureProductionSource(4);

    public TheaterCultureProductionSource(int value) {
        super(value);
    }
}
