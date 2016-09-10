package org.inego.tta2;

import org.inego.tta2.player.IPlayer;
import org.inego.tta2.player.RandomPlayer;

/**
 * Created by Inego on 04.09.2016.
 */
public class RandomGame {

    public static void main(String... args)
    {
        RandomPlayer randomPlayer = new RandomPlayer();
        GameManager manager = new GameManager(new IPlayer[] {randomPlayer, randomPlayer, randomPlayer});

        manager.run();

    }
}
