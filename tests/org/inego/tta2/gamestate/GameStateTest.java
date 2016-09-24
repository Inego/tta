package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.gamestate.comparison.PlayerComparison;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void testUpdateWaitingTurns() {

        GameState gameState = new GameState(2);

        assertArrayEquals(new Integer[] {0, 1}, gameState.getWaitingTurnsArray());

        gameState = new GameState(4);

        assertArrayEquals(new Integer[] {0, 1, 2, 3}, gameState.getWaitingTurnsArray());

        gameState.endPlayerTurn();

        assertArrayEquals(new Integer[] {3, 0, 1, 2}, gameState.getWaitingTurnsArray());

        gameState.endPlayerTurn();

        assertArrayEquals(new Integer[] {2, 3, 0, 1}, gameState.getWaitingTurnsArray());

        gameState.endPlayerTurn();

        assertArrayEquals(new Integer[] {1, 2, 3, 0}, gameState.getWaitingTurnsArray());

        gameState.endPlayerTurn();

        assertArrayEquals(new Integer[] {0, 1, 2, 3}, gameState.getWaitingTurnsArray());

    }

    @Test
    public void testSortByMilitaryStrength()
    {
        GameState gameState = new GameState(4);

        PlayerState p0 = gameState.getPlayerState(0);
        PlayerState p1 = gameState.getPlayerState(1);
        PlayerState p2 = gameState.getPlayerState(2);
        PlayerState p3 = gameState.getPlayerState(3);

        // Every player has military strength of 1, so the order is judged by current player order

        assertEquals(Arrays.asList(p0, p1, p2, p3), gameState.getPlayersSortedBy(PlayerComparison.MILITARY_STRENGTH));

        gameState.endPlayerTurn();
        assertEquals(Arrays.asList(p1, p2, p3, p0), gameState.getPlayersSortedBy(PlayerComparison.MILITARY_STRENGTH));

        // Make p3 and p0 the two strongest
        p3.build(Cards.WARRIORS);
        p0.build(Cards.WARRIORS);

        assertEquals(Arrays.asList(p3, p0, p1, p2), gameState.getPlayersSortedBy(PlayerComparison.MILITARY_STRENGTH));

        p0.build(Cards.WARRIORS);
        assertEquals(Arrays.asList(p0, p3, p1, p2), gameState.getPlayersSortedBy(PlayerComparison.MILITARY_STRENGTH));

    }




}