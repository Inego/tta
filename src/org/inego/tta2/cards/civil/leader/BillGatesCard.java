package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 28.10.2016.
 */
public class BillGatesCard extends LeaderCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Bill Gates";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {

        playerState.iterateBuildings(CivilCardKind.LAB, e -> {
            playerState.modifyResourceProduction(sign * e.getAge() * e.qty);
        });

        if (sign == -1) {
            playerState.gainBillGatesCulture();
        }
    }
}
