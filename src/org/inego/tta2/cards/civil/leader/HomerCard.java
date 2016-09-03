package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;

/**
 * Created by Inego on 28.08.2016.
 */
public class HomerCard extends LeaderCard {


    public static final Choice ATTACH_HAPPY_FACE = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            playerState.addHappinessSource(HappinessSource.HOMER_EPIC);
        }
    };

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return "Homer";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyHappinessSource(HappinessSource.HOMER, sign);
        playerState.modifyMilitaryProductionBonus(sign);
    }
}
