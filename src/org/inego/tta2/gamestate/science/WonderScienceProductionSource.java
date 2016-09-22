package org.inego.tta2.gamestate.science;

public class WonderScienceProductionSource extends ScienceProductionSource {

    public static final WonderScienceProductionSource UNIVERSITAS_CAROLINA = new WonderScienceProductionSource(2);
    public static final WonderScienceProductionSource LIBRARY_OF_ALEXANDRIA = new WonderScienceProductionSource(1);

    public WonderScienceProductionSource(int value) {
        super(value);
    }
}
