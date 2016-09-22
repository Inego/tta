package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class PhalanxCard extends TacticCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Phalanx";
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
    public int getCavalry() {
        return 1;
    }

    @Override
    public int getNormalBonus() {
        return 3;
    }

    @Override
    public int getObsoleteBonus() {
        return 3;
    }
}
