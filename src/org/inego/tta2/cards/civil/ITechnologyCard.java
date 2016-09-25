package org.inego.tta2.cards.civil;

import org.inego.tta2.cards.ICard;
import org.inego.tta2.gamestate.PlayerState;

public interface ITechnologyCard extends ICard {

    default int getResearchCost(PlayerState playerState) {
        return getNominalResearchCost();
    }

    int getNominalResearchCost();

}
