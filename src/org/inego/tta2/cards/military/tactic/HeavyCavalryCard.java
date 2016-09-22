package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class HeavyCavalryCard extends TacticCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Heavy Cavalry";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getCavalry() {
        return 3;
    }

    @Override
    public int getNormalBonus() {
        return 4;
    }

    @Override
    public int getObsoleteBonus() {
        return 4;
    }
}
