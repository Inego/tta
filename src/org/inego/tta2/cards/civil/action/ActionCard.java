package org.inego.tta2.cards.civil.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

import java.util.Iterator;

public abstract class ActionCard extends CivilCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.ACTION;
    }

}
