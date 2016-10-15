package org.inego.tta2.player;

import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.IGameState;

import java.util.List;

/**
 * Created by Inego on 15.10.2016.
 */
public class MockPlayer implements IPlayer {

    IChoice mockChoice;

    @Override
    public int choose(IGameState gameState, List<? extends IChoice> choices) {
        if (mockChoice != null) {
            int result = choices.indexOf(mockChoice);
            mockChoice = null;
            if (result != -1) {
                return result;
            }
        }
        return 0;
    }

    public void mock(IChoice choice) {
        mockChoice = choice;
    }
}
