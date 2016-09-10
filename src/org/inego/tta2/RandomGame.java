package org.inego.tta2;

import org.inego.tta2.player.IPlayer;

/**
 * Created by Inego on 04.09.2016.
 */
public class RandomGame {

    public static void main(String... args)
    {
        GameManager manager = new GameManager(new IPlayer[] {});



        manager.run();

    }
}
