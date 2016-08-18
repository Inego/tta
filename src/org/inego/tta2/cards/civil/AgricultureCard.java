package org.inego.tta2.cards.civil;

/**
 * Created by Inego on 16.08.2016.
 */
public class AgricultureCard extends BuildingCard {
    @Override
    public CivilCardKind getCivilCardKind() {
        return CivilCardKind.FARM;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int getResearchCost() {
        return 0;
    }

    @Override
    public int getBuildCost() {
        return 2;
    }
}
