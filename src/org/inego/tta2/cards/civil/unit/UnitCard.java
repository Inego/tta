package org.inego.tta2.cards.civil.unit;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.tactics.Composition;

/**
 * Created by Inego on 21.08.2016.
 */
public abstract class UnitCard extends BuildingCard {

    protected abstract int getStrength();

    @Override
    public void assignWorker(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(getStrength());
    }

    public void addToComposition(Composition composition, int qty, int age) {
        addToComposition(composition, qty, getAge() >= age - 1);
    }

    abstract void addToComposition(Composition composition, int qty, boolean modern);
}
