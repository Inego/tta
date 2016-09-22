package org.inego.tta2.gamestate.culture;

/**
 *
 */
public class WonderCultureProductionSource extends CultureProductionSource {

    public static final WonderCultureProductionSource LIBRARY_OF_ALEXANDRIA = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource HANGING_GARDENS = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource KREMLIN = new WonderCultureProductionSource(2);
    public static final WonderCultureProductionSource UNIVERSITAS_CAROLINA = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource GREAT_WALL = new WonderCultureProductionSource(1);
    public static final WonderCultureProductionSource ST_PETERS = new WonderCultureProductionSource(2);
    public static final WonderCultureProductionSource TAJ_MAHAL = new WonderCultureProductionSource(3);
    public static final WonderCultureProductionSource EIFFEL_TOWER = new WonderCultureProductionSource(4);

    public WonderCultureProductionSource(int value) {
        super(value);
    }
}
