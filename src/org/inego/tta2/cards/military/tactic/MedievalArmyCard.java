package org.inego.tta2.cards.military.tactic;

/**
 * Created by Inego on 21.08.2016.
 */
public class MedievalArmyCard extends TacticCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Medieval Army";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
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
    public int getNormalBonus() {
        return 2;
    }

    @Override
    public int getObsoleteBonus() {
        return 2;
    }
}
