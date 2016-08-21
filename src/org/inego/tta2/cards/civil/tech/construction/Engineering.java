package org.inego.tta2.cards.civil.tech.construction;

/**
 * Created by Inego on 21.08.2016.
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
