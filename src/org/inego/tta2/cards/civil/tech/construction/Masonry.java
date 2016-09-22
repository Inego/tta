package org.inego.tta2.cards.civil.tech.construction;

/**
 *
 */
public class Masonry extends ConstructionTechCard {

    @Override
    public int getAge() {
        return 1;
    }

    @Override
    public String getName() {
        return "Masonry";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }
}
