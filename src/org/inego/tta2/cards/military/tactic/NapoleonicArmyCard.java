package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class NapoleonicArmyCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Napoleonic Army";
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
        return 1;
    }

    @Override
    public int getArtillery() {
        return 1;
    }

    @Override
    public int getNormalBonus() {
        return 7;
    }

    @Override
    public int getObsoleteBonus() {
        return 4;
    }
}
