package org.inego.tta2.cards.civil.action;

public class WaveOfNationalismCard extends ComparedMilitaryActionCard {

    private static final int[] BOOST = new int[] {6, 3, 2};

    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Wave of Nationalism";
    }

    @Override
    protected int[] getBoost() {
        return BOOST;
    }
}
