package org.inego.tta2.gamestate.culture;

/**
 * Created by Inego on 27.08.2016.
 */
public abstract class CultureProductionSource {

    public static final BuildingCultureProductionSource TEMPLE = new BuildingCultureProductionSource(1);

    public static final LibraryCultureProductionSource PRINTING_PRESS = new LibraryCultureProductionSource(1);
    public static final LibraryCultureProductionSource JOURNALISM = new LibraryCultureProductionSource(2);
    public static final LibraryCultureProductionSource MULTIMEDIA = new LibraryCultureProductionSource(3);

    public static final TheaterCultureProductionSource DRAMA = new TheaterCultureProductionSource(2);
    public static final TheaterCultureProductionSource OPERA = new TheaterCultureProductionSource(3);
    public static final TheaterCultureProductionSource MOVIES = new TheaterCultureProductionSource(4);

    public static final GovernmentCultureProductionSource THEOCRACY = new GovernmentCultureProductionSource(1);
    public static final GovernmentCultureProductionSource DEMOCRACY = new GovernmentCultureProductionSource(3);

    public static final WonderCultureProductionSource LIBRARY_OF_ALEXANDRIA = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource HANGING_GARDENS = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource KREMLIN = new WonderCultureProductionSource(2);
    public static final WonderCultureProductionSource UNIVERSITAS_CAROLINA = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource GREAT_WALL = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource ST_PETERS = new WonderCultureProductionSource(2);
    public static final WonderCultureProductionSource TAJ_MAHAL = new WonderCultureProductionSource(3);
    public static final WonderCultureProductionSource EIFFEL_TOWER = new WonderCultureProductionSource(4);


    private int value;

    public CultureProductionSource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
