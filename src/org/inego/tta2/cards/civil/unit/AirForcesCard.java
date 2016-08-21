package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.CivilCardKind;

/**
 * Created by Inego on 21.08.2016.
 */
public class AirForcesCard extends UnitCard {
    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.AIR_FORCE;
    }

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Air Forces";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getResearchCost() {
        return 12;
    }

    @Override
    public int getBuildCost() {
        return 7;
    }

    @Override
    protected int getStrength() {
        return 5;
    }
}
