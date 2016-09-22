package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class MechanizedArmyCard extends TacticCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Mechanized Army";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getCavalry() {
        return 1;
    }

    @Override
    public int getArtillery() {
        return 2;
    }

    @Override
    public int getNormalBonus() {
        return 10;
    }

    @Override
    public int getObsoleteBonus() {
        return 5;
    }
}
