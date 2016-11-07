package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.PlayerState;

public class EndowmentForArtsCard extends SimpleActionCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Endowment for Arts";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    protected void performAction(PlayerState playerState) {

        int number = 0;

        GameState gameState = playerState.getGameState();

        for (PlayerState other : gameState.getPlayerStates()) {
            if (other == playerState)  continue;
            if (other.getCulturePoints() > playerState.getCulturePoints()) number++;
        }

        if (number > 0) {
            int multiplier = 3;
            int numberOfPlayers = gameState.getNumberOfPlayers();
            if (numberOfPlayers == 2)
                multiplier = 6;
            else if (numberOfPlayers == 4)
                multiplier = 2;
            playerState.gainCulturePoints(number * multiplier);
        }
    }
}
