package org.inego.tta2.player;

import org.inego.tta2.gamestate.IChoice;
import org.inego.tta2.gamestate.IGameState;
import org.inego.tta2.player.IPlayer;

import java.util.List;
import java.util.Random;

/**
 * Created by Inego on 10.09.2016.
 */
public class RandomPlayer implements IPlayer {

    private Random random = new Random();

    @Override
    public int choose(IGameState gameState, List<? extends IChoice> choices) {
        return random.nextInt(choices.size());
    }
}
