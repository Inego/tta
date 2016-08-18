package org.inego.tta2.gamestate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inego on 16.08.2016.
 */
public class GameState implements IGameState {

    private int numberOfPlayers;

    private List<PlayerState> playerStates;

    public GameState(int numberOfPlayers) {

        this.numberOfPlayers = numberOfPlayers;

        playerStates = new ArrayList<>(numberOfPlayers);

        for (int i = 0; i < numberOfPlayers; i++) {
            playerStates.add(new PlayerState());
        }
    }

    public GameState(GameState source) {
        // TODO clone
    }

    @Override
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
