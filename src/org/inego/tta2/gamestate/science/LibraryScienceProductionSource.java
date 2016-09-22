package org.inego.tta2.gamestate.science;

/**
 *
 */
public class LibraryScienceProductionSource extends ScienceProductionSource {


    public static final LibraryScienceProductionSource PRINTING_PRESS = new LibraryScienceProductionSource(1);
    public static final LibraryScienceProductionSource JOURNALISM = new LibraryScienceProductionSource(2);
    public static final LibraryScienceProductionSource MULTIMEDIA = new LibraryScienceProductionSource(3);

    public LibraryScienceProductionSource(int value) {
        super(value);
    }
}
