package org.inego.tta2.cards.civil.upgrade;

import org.inego.tta2.cards.civil.BuildingCard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Produces unique upgrade descriptions
 */
public class UpgradeDescriptionFactory {

    public static final Map<BuildingCard, Map<BuildingCard, UpgradeDescription>> descriptions = new HashMap<>();

    public static UpgradeDescription get(BuildingCard source, BuildingCard destination) {

        Map<BuildingCard, UpgradeDescription> destinationMap = descriptions.get(source);

        if (destinationMap == null) {
            destinationMap = new HashMap<>();
            descriptions.put(source, destinationMap);
        }

        UpgradeDescription result = destinationMap.get(destination);

        if (result == null) {
            result = new UpgradeDescription(source, destination);
            destinationMap.put(destination, result);
        }

        return result;
    }

}
