package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 *
 */
public abstract class UnitCard extends BuildingCard {

    public static final CivilCardKind[] ALL_KINDS = {CivilCardKind.INFANTRY, CivilCardKind.CAVALRY, CivilCardKind.ARTILLERY, CivilCardKind.AIR_FORCE};
    public static final CivilCardKind[] TACTIC_KINDS = {CivilCardKind.INFANTRY, CivilCardKind.CAVALRY, CivilCardKind.ARTILLERY};

    protected abstract int getStrength();

    public abstract UnitType getUnitType();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * getStrength());
    }

    public void addToComposition(Composition composition, int qty, int age) {
        addToComposition(composition, qty, getAge() >= age - 1);
    }

    abstract void addToComposition(Composition composition, int qty, boolean modern);
}
