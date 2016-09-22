package org.inego.tta2.cards.civil.tech;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class TechnologyCard extends CivilCard implements ITechnologyCard {

    public abstract void apply(int sign, PlayerState playerState);

}
