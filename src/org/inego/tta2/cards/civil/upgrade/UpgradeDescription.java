package org.inego.tta2.cards.civil.upgrade;

import org.inego.tta2.cards.civil.BuildingCard;

public class UpgradeDescription implements Comparable<UpgradeDescription> {

    public BuildingCard source;
    public BuildingCard destination;
    public int delta;

    public UpgradeDescription(BuildingCard source, BuildingCard destination) {
        this.source = source;
        this.destination = destination;
        this.delta = destination.getNominalCost() - source.getNominalCost();
    }

    @Override
    public int compareTo(UpgradeDescription o) {
        int result  = this.delta - o.delta;
        if (result != 0)
            return result;

        result = this.source.getKind().compareTo(o.source.getKind());

        if (result != 0)
            return result;

        return this.source.getAge()- o.source.getAge();
    }

    @Override
    public String toString() {
        return source.toString() + "->" + destination.toString();
    }
}
