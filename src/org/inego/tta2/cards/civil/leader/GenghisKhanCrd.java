package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 17.09.2016.
 */
public class GenghisKhanCrd extends LeaderCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Genghis Khan";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        // TODO Genghis Khan
    }
}
