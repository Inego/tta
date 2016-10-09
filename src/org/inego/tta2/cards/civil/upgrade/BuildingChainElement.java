package org.inego.tta2.cards.civil.upgrade;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.unit.UnitCard;

/**
 *
 */
public class BuildingChainElement {

    public final BuildingCard buildingCard;

    public int qty;

    public BuildingChainElement next;
    public BuildingChainElement prev;

    public BuildingChainElement(BuildingCard buildingCard, int qty) {

        this.buildingCard = buildingCard;
        this.qty = qty;
    }

    public int getAge() {
        return buildingCard.getAge();
    }
}
