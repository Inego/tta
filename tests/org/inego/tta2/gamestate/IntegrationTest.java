package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.gamestate.choice.action.UpgradeChoice;
import org.inego.tta2.gamestate.point.ActionPhase;
import org.inego.tta2.player.MockPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Inego on 15.10.2016.
 */
public class IntegrationTest {

    private DebugGameManager debugGameManager;
    private MockPlayer p1;
    private MockPlayer p2;
    private MockPlayer p3;


    @Before
    public void setUp() {
        p1 = new MockPlayer();
        p2 = new MockPlayer();
        p3 = new MockPlayer();
        debugGameManager = new DebugGameManager(p1, p2, p3);
    }

    @Test
    public void testUpgradeChoice() {

        GameState gameState = debugGameManager.getGameState();

        debugGameManager.runTo(g -> g.getPointStack().peek() instanceof ActionPhase
            && g.getAge() == 1);

        PlayerState currentPlayerState = gameState.getCurrentPlayerState();

        assertEquals(0, currentPlayerState.getIndex());

        assertEquals(4, currentPlayerState.getAvailableCivilActions());

        currentPlayerState.discover(Cards.SWORDSMEN);

        currentPlayerState.debugSetResources(1);

        debugGameManager.next();

        UpgradeChoice found = getUpgradeChoice(gameState, Cards.WARRIORS, Cards.SWORDSMEN);
        assertNotNull(found);
        p1.mock(found);

        debugGameManager.next();

        assertEquals(3, currentPlayerState.getAvailableCivilActions());
        assertEquals(0, currentPlayerState.getBuildingQty(Cards.WARRIORS));
        assertEquals(1, currentPlayerState.getBuildingQty(Cards.SWORDSMEN));

        debugGameManager.next();

        found = getUpgradeChoice(gameState, Cards.WARRIORS, Cards.SWORDSMEN);

        assertNull(found);

    }

    private UpgradeChoice getUpgradeChoice(GameState gameState, BuildingCard from, BuildingCard to) {
        for (IChoice choice : gameState.getChoices()) {
            if (choice instanceof UpgradeChoice) {
                UpgradeChoice upgradeChoice = (UpgradeChoice) choice;
                if (upgradeChoice.from == from && upgradeChoice.to == to) {
                    return upgradeChoice;
                }
            }
        }
        return null;
    }
}
