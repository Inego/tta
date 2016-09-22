package org.inego.tta2.cards.civil.library;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 *
 */
public abstract class LibraryCard extends BuildingCard{

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.LIBRARY;
    }

}
