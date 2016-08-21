package org.inego.tta2.cards.military.tactic;

/**
 * Created by Inego on 21.08.2016.
 */
public class EntrenchmentsCard extends TacticCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Entrenchments";
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
    public int getArtillery() {
        return 2;
    }

    @Override
    public int getNormalBonus() {
        return 9;
    }

    @Override
    public int getObsoleteBonus() {
        return 5;
    }
}
