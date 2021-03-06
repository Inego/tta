package org.inego.tta2.cards.civil.tech.construction;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.tech.TechnologyCard;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class ConstructionTechCard extends TechnologyCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TECH_CONSTRUCTION;
    }

    @Override
    public int getNominalResearchCost() {
        return 3 * getAge();
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        // Do nothing --- special building bonuses calculated in corresponding methods
        // TODO Wonder building bonus
        // TODO Construction discount bonus
    }
}
