package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.exception.GameStateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Inego on 16.08.2016.
 */
public class GameState implements IGameState {

    private int numberOfPlayers;
    private int currentPlayer;

    private List<PlayerState> playerStates;
    private Stack<GamePoint> gamePoints;
    private List<Choice> currentChoices;

    private int currentAge;

    public GameState(int numberOfPlayers) {

        gamePoints = new Stack<>();

        this.numberOfPlayers = numberOfPlayers;

        currentPlayer = 0;
        currentAge = 0; // A

        playerStates = new ArrayList<>(numberOfPlayers);

        for (int i = 1; i <= numberOfPlayers; i++) {
            PlayerState playerState = new PlayerState(this);
            playerStates.add(playerState);

            // Age A specific setup
            playerState.setAvailableCivilActions(i);
        }
    }

    public GameState(GameState source) {
        // TODO clone
    }

    @Override
    public IGamePoint getPoint() {
        return gamePoint;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void next(int choiceIdx) throws GameStateException {
        // TODO GameState.next
    }

    @Override
    public List<? extends IChoice> getChoices() {
        return currentChoices;
    }

    public void proceedTo(GamePoint gamePoint) {
        this.gamePoint = gamePoint;
        currentChoices.clear();
    }

    public void proceedTo(GamePoint gamePoint, Choice... choices) {
        this.gamePoint = gamePoint;
        currentChoices = Arrays.asList(choices);
    }

    public void startPlayerTurn() {

        if (currentAge == 0)
            startActionPhase();
        else
            startPoliticalPhase();
    }

    public void endPlayerTurn() {

        currentPlayer++;
        if (currentPlayer == numberOfPlayers)
            currentPlayer = 0;



    }

    public void startPoliticalPhase() {
        // TODO start political phase
        proceedTo(GamePoint.POLITICAL_PHASE);
    }

    public void startActionPhase() {
        // TODO start action phase
        proceedTo(GamePoint.ACTION_PHASE);
    }

    public PlayerState getCurrentPlayerState() {
        return playerStates.get(currentPlayer);
    }
}
