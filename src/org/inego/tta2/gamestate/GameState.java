package org.inego.tta2.gamestate;

import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.point.GamePoint;
import org.inego.tta2.gamestate.point.IGamePoint;

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
            playerState.setAvailableMilitaryActions(0);
        }

        gamePoints.push(GamePoint.START_TURN);
    }

    public GameState(GameState source) {
        // TODO clone
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public Stack<? extends IGamePoint> getPointStack() {
        return gamePoints;
    }

    @Override
    public List<IGameEvent> getLastEvents() {
        return null;
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void next(int choiceIdx) {
        if (!currentChoices.isEmpty()) {
            currentChoices.get(choiceIdx).apply(this);
            currentChoices.clear();
        }
        GamePoint gamePoint = gamePoints.pop();
        gamePoint.apply(this);
    }

    @Override
    public List<? extends IChoice> getChoices() {
        return currentChoices;
    }

    public void proceedTo(GamePoint gamePoint) {
        gamePoints.push(gamePoint);
        currentChoices.clear();
    }

    public void proceedTo(GamePoint gamePoint, Choice... choices) {
        gamePoints.push(gamePoint);
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

    public int getAge() {
        return currentAge;
    }



    public void replenishCardRow() {
        // TODO replenish card row
    }

    public MilitaryCard[] drawMilitaryCards(int cardsToDraw) {
        // TODO draw military cards p. 6
        return null;
    }
}
