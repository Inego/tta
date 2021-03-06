package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class ConquistadorsCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Conquistadors";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getInfantry() {
        return 1;
    }

    @Override
    public int getCavalry() {
        return 2;
    }

    @Override
    public int getNormalBonus() {
        return 5;
    }

    @Override
    public int getObsoleteBonus() {
        return 3;
    }
}
