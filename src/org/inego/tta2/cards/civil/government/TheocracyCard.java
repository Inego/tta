package org.inego.tta2.cards.civil.government;

import org.inego.tta2.gamestate.HappinessSource;
import org.inego.tta2.gamestate.PlayerState;
import org.inego.tta2.gamestate.culture.CultureProductionSource;

/**
 * Created by Inego on 21.08.2016.
 */
public class TheocracyCard extends GovernmentCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Theocracy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getMaxCivilActions() {
        return 4;
    }

    @Override
    public int getMaxMilitaryActions() {
        return 3;
    }

    @Override
    public int getUrbanBuildingLimit() {
        return 3;
    }

    @Override
    public int getRevolutionCost() {
        return 1;
    }

    @Override
    public int getResearchCost() {
        return 6;
    }

    @Override
    public void apply(int sign, PlayerState playerState) {
        playerState.modifyCultureProductionSource(sign, CultureProductionSource.THEOCRACY);
        playerState.modifyMilitaryStrengthBase(sign);
        playerState.modifyHappinessSource(HappinessSource.THEOCRACY, sign);
    }
}
