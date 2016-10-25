package org.inego.tta2.cards.civil.leader;

import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.LeaderCultureProductionSource;

public class MahatmaGandhiCard extends LeaderCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Mahatma Gandhi";
    }

    @Override
    public void onElect(int sign, PlayerState playerState, LeaderCard other) {
        playerState.modifyCultureProductionSource(sign, LeaderCultureProductionSource.MAHATMA_GANDHI);
    }
}
