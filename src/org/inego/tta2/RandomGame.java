package org.inego.tta2;

import org.inego.tta2.player.IPlayer;
import org.inego.tta2.player.RandomPlayer;

/**
 *
 */
public class RandomGame {

    public static void main(String... args)
    {
        RandomPlayer randomPlayer = new RandomPlayer();
        GameManager manager = new GameManager(new IPlayer[] {randomPlayer, randomPlayer, randomPlayer});

        manager.run();

    }
}
