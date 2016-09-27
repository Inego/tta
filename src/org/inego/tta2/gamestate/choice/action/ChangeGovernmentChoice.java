package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Peaceful change of government
 */
public class ChangeGovernmentChoice extends ActionPhaseChoice {

    private GovernmentCard card;
    private int scienceCost;

    public ChangeGovernmentChoice(GovernmentCard card, int scienceCost) {
        this.card = card;
        this.scienceCost = scienceCost;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {
        playerState.discoverGovernment(card, scienceCost);
    }

}
