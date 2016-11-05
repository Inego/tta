package org.inego.tta2.cards.civil.wonder;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

import javax.smartcardio.Card;

public abstract class WonderCard extends CivilCard {

    @Override
    public CivilCardKind getKind() {
        return CivilCardKind.WONDER;
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    public abstract int[] getStages();

    public abstract void onBuild(PlayerState playerState);

    @Override
    public int getTakingCost(int baseCost, PlayerState playerState) {

        if (playerState.getCurrentWonder() == null)
            return -1;

        if (playerState.getLeader() == Cards.MICHELANGELO) {
            return baseCost;
        }
        return baseCost + playerState.getWonders().size();
    }

    @Override
    public void generateChoices(PlayerState playerState) {
        // Wonder cards are unique in that when taken they instantly get into play.
        // Because of that, they never exist in hand. Probably that should be reflected
        // in class hierarchy but so far it's OK
    }

    @Override
    public void onTake(PlayerState playerState) {
        super.onTake(playerState);
        // TODO on take wonder start building it
    }
}
