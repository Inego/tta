package org.inego.tta2.cards.military.tactic;

/**
 * Created by Inego on 21.08.2016.
 */
public class FightingBandCard extends TacticCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Fighting Band";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getInfantry() {
        return 2;
    }

    @Override
    public int getNormalBonus() {
        return 1;
    }

    @Override
    public int getObsoleteBonus() {
        return 1;
    }
}
