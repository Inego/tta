package org.inego.tta2.gamestate;

import org.inego.tta2.gamestate.point.ActionPhase;
import org.inego.tta2.player.MockPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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

        boolean ran = debugGameManager.runTo(gameState -> gameState.getPointStack().peek() instanceof ActionPhase);

        assertTrue(ran);

    }
}
