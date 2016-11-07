package org.inego.tta2.cards.civil.action;

public class MilitaryBuildUpCard extends ComparedMilitaryActionCard {

    private static final int[] BOOST = new int[] {8, 5, 3};

    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Military Build-Up";
    }

    @Override
    protected int[] getBoost() {
        return BOOST;
    }
}
