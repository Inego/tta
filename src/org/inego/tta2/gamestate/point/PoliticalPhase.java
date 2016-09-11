package org.inego.tta2.gamestate.point;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.leader.AlexanderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.political.PoliticalPhaseChoice;

/**
 * Created by Inego on 10.09.2016.
 */
public class PoliticalPhase extends GamePoint {
    @Override
    public void apply(GameState gameState, PlayerState playerState) {

        // TODO collect political phase choices

        if (playerState.getLeader() == Cards.ALEXANDER) {
            gameState.addChoice(AlexanderCard.REMOVE);
        }

        gameState.addChoice(PoliticalPhaseChoice.PASS);

    }
}
