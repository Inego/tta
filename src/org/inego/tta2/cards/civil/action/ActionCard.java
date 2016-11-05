package org.inego.tta2.cards.civil.action;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.PlayCardFromHandChoice;

import java.util.Iterator;

public abstract class ActionCard extends CivilCard {

    @Override
    public final CivilCardKind getKind() {
        return CivilCardKind.ACTION;
    }

}
