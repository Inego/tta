package org.inego.tta2.cards.civil.lab;

/**
 * Created by Inego on 20.08.2016.
 */
public class AlchemyCard extends LabCard {
    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Alchemy";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers < 4 ? 2 : 3;
    }

    @Override
    public int getBuildCost() {
        return 6;
    }

    @Override
    public int getResearchCost() {
        return 4;
    }

    @Override
    public int getScienceYield() {
        return 2;
    }
}
