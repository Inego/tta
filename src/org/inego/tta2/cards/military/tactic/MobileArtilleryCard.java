package org.inego.tta2.cards.military.tactic;

/**
 * Created by Inego on 21.08.2016.
 */
public class MobileArtilleryCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Mobile Artillery";
    }

    @Override
    public int getQty(int numberOfPlayers) {
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
        return 5;
    }

    @Override
    public int getObsoleteBonus() {
        return 3;
    }
}
