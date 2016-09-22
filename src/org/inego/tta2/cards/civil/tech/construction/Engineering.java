package org.inego.tta2.cards.civil.tech.construction;

/**
 *
 */
public class Engineering extends ConstructionTechCard {
    @Override
    public int getAge() {
        return 3;
    }

    @Override
    public String getName() {
        return "Engineering";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
