package org.inego.tta2.cards.civil.tech.colonization;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.tech.TechnologyCard;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class ColonizationTechCard extends TechnologyCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.TECH_COLONIZATION;
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getNominalResearchCost() {
        return 2 * (1 + getAge());
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyMilitaryStrengthBase(sign * getAge());
        playerState.modifyColonizationBonus(sign * (getAge() + 1));
    }
}
