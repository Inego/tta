package org.inego.tta2.cards.military.tactic;

/**
 * Created by Inego on 21.08.2016.
 */
public class ShockTroopsCard extends TacticCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Shock troops";
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
        return 3;
    }

    @Override
    public int getNormalBonus() {
        return 11;
    }

    @Override
    public int getObsoleteBonus() {
        return 6;
    }
}
