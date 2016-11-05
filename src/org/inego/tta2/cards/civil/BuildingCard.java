package org.inego.tta2.cards.civil;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.action.PlayCardFromHandChoice;

public abstract class BuildingCard extends CivilCard implements ITechnologyCard {

    public abstract int getNominalCost();

    public abstract void assignWorker(int sign, PlayerState playerState);

    public int getBuildingCost(PlayerState playerState) {
        return getNominalCost();
    }

    @Override
    public void generateChoices(PlayerState playerState) {

        int buildingCost = getBuildingCost(playerState);
        if (buildingCost < playerState.getResources())
            return;

        // TODO override in UnitCard so that it takes available military resources into account

        playerState.addChoice(new BuildChoice(this, buildingCost));

    }

    public static class BuildChoice extends PlayCardFromHandChoice<BuildingCard> {

        // TODO test BuildingCard.DiscoverTechnologyChoice

        private final int buildingCost;

        public BuildChoice(BuildingCard cardToPlay, int buildingCost) {
            super(cardToPlay);
            this.buildingCost = buildingCost;
        }

        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            super.apply(gameState, playerState);
            playerState.payResources(buildingCost);
            playerState.build(getCardToPlay());
        }
    }
}
