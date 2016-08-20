package org.inego.tta2.cards.civil.lab;

/**
 * Created by Inego on 20.08.2016.
 */
public class ScientificMethodCard extends LabCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Scientific Method";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 8;
    }

    @Override
    public int getResearchCost() {
        return 6;
    }

    @Override
    public int getScienceYield() {
        return 3;
    }
}
