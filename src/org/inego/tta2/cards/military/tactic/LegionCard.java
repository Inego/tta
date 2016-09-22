package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class LegionCard extends TacticCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Legion";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getInfantry() {
        return 3;
    }

    @Override
    public int getNormalBonus() {
        return 2;
    }

    @Override
    public int getObsoleteBonus() {
        return 2;
    }
}
