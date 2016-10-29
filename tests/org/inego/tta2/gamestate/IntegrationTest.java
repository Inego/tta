package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;
import org.inego.tta2.gamestate.choice.action.UpgradeChoice;
import org.inego.tta2.gamestate.point.ActionPhase;
import org.inego.tta2.gamestate.point.EndGame;
import org.inego.tta2.player.MockPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Inego on 15.10.2016.
 */
public class IntegrationTest {

    private DebugGameManager m;
    private MockPlayer p1;
    private MockPlayer p2;
    private MockPlayer p3;


    @Before
    public void setUp() {
        p1 = new MockPlayer();
        p2 = new MockPlayer();
        p3 = new MockPlayer();
        m = new DebugGameManager(p1, p2, p3);
    }

    @Test
    public void testUpgradeChoice() {

        GameState gameState = m.getGameState();

        m.runTo(g -> g.getPointStack().peek() instanceof ActionPhase
            && g.getAge() == 1);

        PlayerState currentPlayerState = gameState.getCurrentPlayerState();

        assertEquals(0, currentPlayerState.getIndex());

        assertEquals(4, currentPlayerState.getAvailableCivilActions());

        currentPlayerState.discover(Cards.SWORDSMEN);

        currentPlayerState.debugSetResources(1);

        m.next();

        UpgradeChoice found = getUpgradeChoice(Cards.WARRIORS, Cards.SWORDSMEN);
        assertNotNull(found);
        p1.mock(found);

        m.next();

        assertEquals(3, currentPlayerState.getAvailableCivilActions());
        assertEquals(0, currentPlayerState.getBuildingQty(Cards.WARRIORS));
        assertEquals(1, currentPlayerState.getBuildingQty(Cards.SWORDSMEN));

        m.next();

        found = getUpgradeChoice(Cards.WARRIORS, Cards.SWORDSMEN);

        assertNull(found);

    }

    @Test
    public void testBachUpgrade_availableResources() {

        UpgradeChoice found;

        GameState gameState = m.getGameState();

        m.runTo(g -> g.getPointStack().peek() instanceof ActionPhase
                && g.getAge() == 1);

        PlayerState currentPlayerState = gameState.getCurrentPlayerState();

        assertEquals(2, currentPlayerState.getResources());

        currentPlayerState.electLeader(Cards.JS_BACH);
        currentPlayerState.discover(Cards.OPERA);

        m.next();

        found = getUpgradeChoice(Cards.PHILOSOPHY, Cards.OPERA);
        assertNull(found);

        currentPlayerState.gainResources(3); // -> 5

        m.rebuildChoices();

        found = getUpgradeChoice(Cards.PHILOSOPHY, Cards.OPERA);
        assertNotNull(found);

        p1.mock(found);

        m.next();

        // Try another upgrade - it must fail because the Bach's ability has already been used.

        currentPlayerState.build(Cards.PHILOSOPHY);
        currentPlayerState.gainResources(5);

        m.next();

        found = getUpgradeChoice(Cards.PHILOSOPHY, Cards.OPERA);
        assertNull(found);

        // Let's skip to next turn of this player so that the Bach's ability is restored

        endActionPhaseChoice();

        m.runTo(g -> g.getCurrentPlayer() == 0 && g.getPointStack().peek() instanceof ActionPhase);

        m.next();

        found = getUpgradeChoice(Cards.PHILOSOPHY, Cards.OPERA);
        assertNotNull(found);


        // Pro sports cannot be upgraded to opera since it's of a newer age

        currentPlayerState.discover(Cards.PRO_SPORTS);
        currentPlayerState.build(Cards.PRO_SPORTS);

        m.rebuildChoices();

        found = getUpgradeChoice(Cards.PRO_SPORTS, Cards.OPERA);
        assertNull(found);

        // But journalism CAN be upgraded.

        currentPlayerState.discover(Cards.JOURNALISM);

        m.rebuildChoices();

        found = getUpgradeChoice(Cards.JOURNALISM, Cards.OPERA);
        // Cannot upgrade what is not built
        assertNull(found);


        currentPlayerState.build(Cards.JOURNALISM);

        m.rebuildChoices();

        found = getUpgradeChoice(Cards.JOURNALISM, Cards.OPERA);
        assertNotNull(found);

        p1.mock(found);

        m.waitPoints(2); // Apply choice + calc next round of choices

        found = getUpgradeChoice(Cards.JOURNALISM, Cards.OPERA);
        assertNull(found);

        // Build another journalism - but not possible to upgrade to Opera because of the urban building limit of 2 (Despotism)

        currentPlayerState.build(Cards.JOURNALISM);

        m.rebuildChoices();

        found = getUpgradeChoice(Cards.JOURNALISM, Cards.OPERA);
        assertNull(found); // Urban building limit reached

    }

    @Test
    public void testBillGatesEndOfGame() {

        GameState gameState = m.gameState;

        gameState.proceedTo(EndGame.INSTANCE);

        PlayerState p = gameState.getCurrentPlayerState();

        p.electLeader(Cards.BILL_GATES);

        p.debugBuild(Cards.SCIENTIFIC_METHOD);
        p.debugBuild(Cards.COMPUTERS);
        p.debugBuild(Cards.COMPUTERS);

        m.next();

        assertEquals(8, p.getCulturePoints());
    }

    private UpgradeChoice getUpgradeChoice(BuildingCard from, BuildingCard to) {
        for (IChoice choice : m.gameState.getChoices()) {
            if (choice instanceof UpgradeChoice) {
                UpgradeChoice upgradeChoice = (UpgradeChoice) choice;
                if (upgradeChoice.from == from && upgradeChoice.to == to) {
                    return upgradeChoice;
                }
            }
        }
        return null;
    }

    private MockPlayer getCurrentMockPlayer() {
        switch (m.gameState.getCurrentPlayer()) {
            case 0:
                return p1;
            case 1:
                return  p2;
            case 2:
                return p3;
        }
        return null;
    }

    private void endActionPhaseChoice() {
        if (!m.gameState.getChoices().contains(ActionPhaseChoice.END))
            fail("Couldn't find End Action Phase choice");
        getCurrentMockPlayer().mock(ActionPhaseChoice.END);
        m.next();
    }

}
