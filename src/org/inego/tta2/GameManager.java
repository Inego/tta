package org.inego.tta2;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.exception.GameStateException;
import org.inego.tta2.player.IPlayer;

import java.util.List;

/**
 * Created by Inego on 10.09.2016.
 */
public class GameManager implements IGameManager<GameState> {

    private final IPlayer[] players;

    private GameState gameState;

    public GameManager(IPlayer[] players) {
        this.players = players;
        gameState = new GameState(players.length);
    }


    @Override
    public void run() {

        int choice;

        while (!gameState.getPointStack().empty()) {
            List<? extends IChoice> choices = gameState.getChoices();
            if (!choices.isEmpty())
            {
                final int currentPlayer = gameState.getCurrentPlayer();
                choice = players[currentPlayer].choose(gameState, choices);
            }
            else  choice = -1;
            gameState.next(choice);
        }

    }
}
