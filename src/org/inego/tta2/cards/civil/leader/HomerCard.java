package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.GameState;
import org.inego.tta2.gamestate.happiness.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.choice.Choice;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;

/**
 * Created by Inego on 28.08.2016.
 */
public class HomerCard extends LeaderCard {


    public static final Choice ATTACH_HAPPY_FACE = new Choice() {
        @Override
        protected void apply(GameState gameState, PlayerState playerState) {
            // TODO make a custom (?) happiness source attached to wonder so that it's NOT extendable by StPeters in case the wonder has its own happy faces
            // TODO select wonder choice
            playerState.addHappinessSource(WonderHappinessSource.HOMER_EPIC);
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

        // When Homer is gone, his unused military production bonus is gone with him
        // see https://boardgamegeek.com/article/23613349#23613349
        playerState.setLeaderMilitaryProductionBonus(sign == 1 ? 1 : 0);
    }
}
