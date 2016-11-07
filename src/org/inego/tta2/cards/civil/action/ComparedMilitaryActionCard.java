package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public abstract class ComparedMilitaryActionCard extends SimpleActionCard {

    protected abstract int[] getBoost();

    @Override
    protected void performAction(PlayerState playerState) {

        int number = 0;

        GameState gameState = playerState.getGameState();

        int myStrength = playerState.getMilitaryStrength();

        for (PlayerState other : gameState.getPlayerStates()) {
            if (other == playerState)  continue;
            if (myStrength < other.getMilitaryStrength()) number++;
        }

        if (number > 0) {
            int multiplier = getBoost()[gameState.getNumberOfPlayers() - 2];
            playerState.gainCulturePoints(number * multiplier);
        }

    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
