package org.inego.tta2.cards.civil.lab;

/**
 * Created by Inego on 20.08.2016.
 */
public class ComputersCard extends LabCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Computers";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 2;
    }

    @Override
    public int getBuildCost() {
        return 11;
    }

    @Override
    public int getResearchCost() {
        return 8;
    }

    @Override
    public int getScienceYield() {
        return 5;
    }
}
