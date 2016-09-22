package org.inego.tta2.gamestate.science;

import org.inego.tta2.gamestate.culture.GovernmentCultureProductionSource;

/**
 *
 */
public class GovernmentScienceProductionSource extends ScienceProductionSource {

    public static final GovernmentScienceProductionSource FUNDAMENTALISM = new GovernmentScienceProductionSource(-2);

    public GovernmentScienceProductionSource(int value) {
        super(value);
    }
}
