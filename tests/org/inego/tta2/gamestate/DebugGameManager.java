package org.inego.tta2.gamestate;

import org.inego.tta2.player.IPlayer;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Inego on 15.10.2016.
 */
public class DebugGameManager {

    GameState gameState;

    Predicate<GameState> pauseCondition;

    private IPlayer[] players;

    public DebugGameManager(IPlayer... players) {

        this.players = players;

        gameState = new GameState(players.length);
    }

    public boolean next() {
        return waitPoints(1);
    }

    public boolean waitPoints(int points) {
        return runTo(new WaitPoints(points));
    }

    public boolean runTo(Predicate<GameState> pauseCondition) {
        this.pauseCondition = pauseCondition;
        return run();
    }

    public boolean run() {

        int choice;

        while (!gameState.getPointStack().empty()) {

            if (pauseCondition != null && pauseCondition.test(gameState)) {
                pauseCondition = null;
                return true;
            }

            List<? extends IChoice> choices = gameState.getChoices();
            if (choices.size() > 1)
            {
                final int currentPlayer = gameState.getCurrentPlayer();
                choice = players[currentPlayer].choose(gameState, choices);
            }
            else  choice = 0;
            gameState.next(choice);
        }

        return false;

    }

    public GameState getGameState() {
        return gameState;
    }

    public void rebuildChoices() {

        gameState.getChoices().clear();
        next();

    }

    /**
     * Decrements with every test
     */
    public static class WaitPoints implements Predicate<GameState> {

        int remaining;

        public WaitPoints(int points) {
            remaining = points;
        }

        @Override
        public boolean test(GameState gameState) {
            return (remaining-- <= 0);
        }
    }

}
