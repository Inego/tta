package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class ClassicArmyCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Classic Army";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getInfantry() {
        return 2;
    }

    @Override
    public int getCavalry() {
        return 2;
    }

    @Override
    public int getNormalBonus() {
        return 8;
    }

    @Override
    public int getObsoleteBonus() {
        return 4;
    }
}
