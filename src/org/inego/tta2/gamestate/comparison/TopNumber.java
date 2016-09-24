package org.inego.tta2.gamestate.comparison;

import org.inego.tta2.gamestate.GameState;

public interface TopNumber {

    TopNumber TWO = gameState -> gameState.getNumberOfPlayers() == 2 ? 1 : 2;

    int getTopNumber(GameState gameState);

}
