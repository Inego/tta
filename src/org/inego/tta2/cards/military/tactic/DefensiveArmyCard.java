package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class DefensiveArmyCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Defensive Army";
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
    public int getArtillery() {
        return 1;
    }

    @Override
    public int getNormalBonus() {
        return 6;
    }

    @Override
    public int getObsoleteBonus() {
        return 3;
    }
}
