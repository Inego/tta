package org.inego.tta2.gamestate;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.point.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class GameState implements IGameState {

    private int numberOfPlayers;
    private int currentPlayer;

    private List<PlayerState> playerStates;
    private Stack<GamePoint> gamePoints;
    private List<Choice> currentChoices = new ArrayList<>();
    private List<CivilCard> cardRow = new ArrayList<>();

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

        gamePoints.push(StartTurn.INSTANCE);
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
        if (currentChoices.isEmpty()) {
            GamePoint gamePoint = gamePoints.peek();
            gamePoint.apply(this);
        }
        else {
            Choice choice = currentChoices.get(choiceIdx);
            currentChoices.clear();
            choice.apply(this);
        }
    }

    @Override
    public List<? extends IChoice> getChoices() {
        return currentChoices;
    }

    public void proceedTo(GamePoint gamePoint) {
        gamePoints.pop();
        gamePoints.push(gamePoint);
    }

    public void proceedTo(GamePoint gamePoint, Choice... choices) {
        currentChoices = Arrays.asList(choices);
        proceedTo(gamePoint);
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
        startPoliticalPhase();
    }

    public void startPoliticalPhase() {
        proceedTo(PoliticalPhase.POLITICAL_PHASE);
    }

    public void startActionPhase() {
        proceedTo(ActionPhase.ACTION_PHASE);
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

    public void addChoice(Choice choice) {
        currentChoices.add(choice);
    }

    public CivilCard getCardFromRow(int idx) {
        CivilCard card = cardRow.get(idx);
        if (card == null)
            throw new UnsupportedOperationException("Card already taken from specified idx");
        cardRow.set(idx, null);
        return card;
    }

    public void setCurrentAge(int age) {
        this.currentAge = age;
    }
}
