package org.inego.tta2.cards.military.tactic;

/**
 *
 */
public class FortificationsCard extends TacticCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Fortifications";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    public int getArtillery() {
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
