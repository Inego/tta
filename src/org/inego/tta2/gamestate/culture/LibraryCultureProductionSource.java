package org.inego.tta2.gamestate.culture;

/**
 *
 */
public class LibraryCultureProductionSource extends BuildingCultureProductionSource {

    public static final LibraryCultureProductionSource PRINTING_PRESS = new LibraryCultureProductionSource(1);
    public static final LibraryCultureProductionSource JOURNALISM = new LibraryCultureProductionSource(2);
    public static final LibraryCultureProductionSource MULTIMEDIA = new LibraryCultureProductionSource(3);

    public LibraryCultureProductionSource(int value) {
        super(value);
    }
}
