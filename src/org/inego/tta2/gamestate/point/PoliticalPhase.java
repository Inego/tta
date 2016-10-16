package org.inego.tta2.gamestate.point;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.leader.AlexanderCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.political.PoliticalPhaseChoice;

/**
 *
 */
public class PoliticalPhase extends GamePoint {
    public static final GamePoint INSTANCE = new PoliticalPhase();

    @Override
    public void apply(GameState gameState, PlayerState playerState) {

        // TODO collect political phase choices

        if (playerState.getLeader() == Cards.ALEXANDER) {
            gameState.addChoice(AlexanderCard.REMOVE);
        }
        else if (playerState.getLeader() == Cards.CHRISTOPHER_COLUMBUS) {
            playerState.addColumbusColonizationChoices();
        }


        gameState.addChoice(PoliticalPhaseChoice.PASS);

    }
}
