package org.inego.tta2.cards.civil.tech.construction;

/**
 * Created by Inego on 21.08.2016.
 */
public class ArchitectureCard extends ConstructionTechCard {
    @Override
    public int getAge() {
        return 2;
    }

    @Override
    public String getName() {
        return "Architecture";
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return numberOfPlayers == 2 ? 1 : 2;
    }
}
