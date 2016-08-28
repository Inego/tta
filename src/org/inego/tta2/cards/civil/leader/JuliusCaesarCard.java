package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 27.08.2016.
 */
public class JuliusCaesarCard extends LeaderCard {
    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Julius Caesar";
    }


    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyMilitaryStrength(sign);
        playerState.modifyAdditionalMilitaryActions(sign);
        // Special action - see PoliticalPhaseChoice.apply
    }
}
