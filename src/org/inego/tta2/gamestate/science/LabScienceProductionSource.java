package org.inego.tta2.gamestate.science;

/**
 *
 */
public class LabScienceProductionSource extends ScienceProductionSource {

    public static final LabScienceProductionSource PHILOSOPHY = new LabScienceProductionSource(1);
    public static final LabScienceProductionSource ALCHEMY = new LabScienceProductionSource(2);
    public static final LabScienceProductionSource SCIENTIFIC_METHOD = new LabScienceProductionSource(3);
    public static final LabScienceProductionSource COMPUTERS = new LabScienceProductionSource(5);

    public LabScienceProductionSource(int value) {
        super(value);
    }

}
