package org.inego.tta2.cards.military.tactic;

import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.cards.military.MilitaryCardKind;

/**
 *
 */
public abstract class TacticCard extends MilitaryCard {

    @Override
    public MilitaryCardKind getKind() {
        return MilitaryCardKind.TACTIC;
    }

    // Required army composition

    public int getInfantry() {
        return 0;
    }

    public int getCavalry() {
        return 0;
    }

    public int getArtillery() {
        return 0;
    }

    public abstract int getNormalBonus();
    public abstract int getObsoleteBonus();

}
