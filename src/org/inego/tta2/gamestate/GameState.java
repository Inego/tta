package org.inego.tta2.gamestate;

import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.comparison.TopNumber;
import org.inego.tta2.gamestate.point.*;

import java.util.*;

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
            PlayerState playerState = new PlayerState(this, i - 1);
            playerStates.add(playerState);

            // Age A specific setup
            playerState.setAvailableCivilActions(i);
            playerState.setAvailableMilitaryActions(0);
        }

        updateWaitingTurns();

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
        // TODO attach startPlayerTurn to something useful or move to PlayerState
        if (currentAge == 0)
            startActionPhase();
        else
            startPoliticalPhase();
    }

    public void endPlayerTurn() {
        currentPlayer++;
        if (currentPlayer == numberOfPlayers) {
            currentPlayer = 0;
            if (currentAge == 0) {
                // TODO end Age A
                currentAge++;
            }

        }

        updateWaitingTurns();

        proceedTo(StartTurn.INSTANCE);
    }

    private void updateWaitingTurns() {
        int waitingTurns = currentPlayer == 0 ? 0 : numberOfPlayers - currentPlayer;
        for (PlayerState playerState : playerStates) {
            playerState.setWaitingTurns(waitingTurns);
            waitingTurns++;
            if (waitingTurns == numberOfPlayers)
                waitingTurns = 0;
        }
    }

    public void startPoliticalPhase() {
        proceedTo(PoliticalPhase.INSTANCE);
    }

    public void startActionPhase() {
        proceedTo(ActionPhase.INSTANCE);
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


    public CivilCard peekCardRow(int idx) {
        return cardRow.get(idx);
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

    public boolean isAmongTop(PlayerState playerState, TopNumber topNumber, Comparator<PlayerState> comparator) {
        List<PlayerState> sortedPlayers = getPlayersSortedBy(comparator);
        int topNumberValue = topNumber.getTopNumber(this);
        for (int i = 0; i < topNumberValue; i++) {
            if (sortedPlayers.get(i) == playerState)
                return true;
        }
        return false;
    }

    public List<PlayerState> getPlayersSortedBy(Comparator<PlayerState> comparator) {
        ArrayList<PlayerState> playerStatesCopy = new ArrayList<>(playerStates);
        playerStatesCopy.sort(comparator);
        return playerStatesCopy;
    }

    /**
     * For testing purposes.
     * @return An array of remaining waiting turns of players
     */
    public Integer[] getWaitingTurnsArray() {
        return playerStates.stream().map(PlayerState::getWaitingTurns).toArray(Integer[]::new);
    }

    public PlayerState getPlayerState(int i) {
        return playerStates.get(i);
    }

    public int getIndex(PlayerState playerState) {
        return playerStates.indexOf(playerState);
    }

    public void onEndGame() {

        for (PlayerState playerState : playerStates) {
            playerState.onEndGame();
        }

        // TODO other endgame actions

        getPointStack().clear();
    }
}
