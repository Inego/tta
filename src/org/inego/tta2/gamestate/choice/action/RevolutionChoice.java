package org.inego.tta2.gamestate.choice.action;

import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Violent change of government
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
    public int getCivilActionCost() {
        return robespierre ? 0 : actionPointsCost;
    }

    @Override
    public int getMilitaryActionCost() {
        return robespierre ? actionPointsCost : 0;
    }

    @Override
    protected void apply(GameState gameState, PlayerState playerState) {

        super.apply(gameState, playerState);

        playerState.discoverGovernment(card, scienceCost);

        if (robespierre) {
            playerState.gainCulturePoints(3);
        }
    }

}
