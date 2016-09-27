package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Peaceful change of government
 */
public class RevolutionChoice extends ActionPhaseChoice {

    private final GovernmentCard card;
    private final int scienceCost;
    private final int actionPointsCost;
    private final boolean robespierre;

    public RevolutionChoice(GovernmentCard card, int scienceCost, int actionPointsCost, boolean robespierre) {
        this.card = card;
        this.scienceCost = scienceCost;
        this.actionPointsCost = actionPointsCost;
        this.robespierre = robespierre;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {

        playerState.discoverGovernment(card, scienceCost);

        if (robespierre) {
            playerState.payMilitaryActions(actionPointsCost);
            playerState.gainCulturePoints(3);
        }
        else
            playerState.useCivilActions(actionPointsCost);
    }

}
