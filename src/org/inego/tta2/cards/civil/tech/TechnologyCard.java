package org.inego.tta2.cards.civil.tech;

import org.inego.tta2.cards.civil.CardInHand;
import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.PlayCardFromHandChoice;

public abstract class TechnologyCard extends CivilCard implements ITechnologyCard {

    public abstract void apply(int sign, PlayerState playerState);

    @Override
    public void generateChoices(PlayerState playerState) {

        int researchCost = getResearchCost(playerState);

        if (playerState.getSciencePoints() >= researchCost)
            playerState.addChoice(new DiscoverTechnologyChoice(this, researchCost));

    }

    public static class DiscoverTechnologyChoice extends PlayCardFromHandChoice<TechnologyCard> {

        private final int researchCost;

        public DiscoverTechnologyChoice(TechnologyCard technologyCard, int researchCost) {
            super(technologyCard);
            this.researchCost = researchCost;
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            super.apply(gameState, playerState);
            playerState.paySciencePoints(researchCost);
            playerState.discover(getCard());
        }
    }
}
