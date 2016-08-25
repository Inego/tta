package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.tech.civil.CivilTechCard;
import org.inego.tta2.cards.civil.tech.colonization.ColonizationTechCard;
import org.inego.tta2.cards.civil.tech.construction.ConstructionTechCard;
import org.inego.tta2.cards.civil.tech.military.MilitaryTechCard;
import org.inego.tta2.cards.civil.wonder.WonderCard;
import org.inego.tta2.cards.military.tactic.TacticCard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Inego on 16.08.2016.
 */
public class PlayerState {

    private int foodProduction;
    private int resourceProduction;
    private int cultureProduction;
    private int scienceProduction;
    private int militaryStrength;

    private Map<HappinessSource, Integer> happinessSources = new HashMap<>();

    private int happiness;

    private int blueBank;
    private int yellowBank;

    private int workerPool;

    private int maxCivilActions;
    private int maxMilitaryActions;
    private int additionalMilitaryActions;
    private int additionalCivilActions;

    private GovernmentCard government;

    // Technologies
    private MilitaryTechCard militaryTech;
    private CivilTechCard civilTech;
    private ColonizationTechCard colonizationTech;
    private ConstructionTechCard constructionTech;

    // Wonders
    private Set<WonderCard> wonders;

    // Tactics
    private TacticCard tactic;
    private int normalArmies;
    private int obsoleteArmies;

    private int culturePoints;
    private int sciencePoints;

    private int colonizationBonus;
    private boolean recalcHappiness;

    public PlayerState() {
        yellowBank = 18;
        recalcHappiness = false;
        workerPool = 1;
        tactic = null;
        government = Cards.DESPOTISM;
        wonders = new LinkedHashSet<>();
    }

    public int getFoodProduction() {
        return foodProduction;
    }

    public int getResourceProduction() {
        return resourceProduction;
    }


    public void modifyFoodProduction(int delta)
    {
        foodProduction += delta;
    }

    public int getCulturePoints() {
        return sciencePoints;
    }

    public int getHappiness() {
        if (recalcHappiness)
            recalculateHappiness();
        return happiness;
    }

    private void recalculateHappiness() {
        happiness = 0;
        int modifier = isCardBuilt(Cards.ST_PETERS_BASILICA) ? 1 : 0;
        int baseValue;
        for (HappinessSource happinessSource : happinessSources.keySet()) {
            baseValue = happinessSource.getValue(this);
            happiness += happinessSource.getValue(this) + (baseValue > 0 ? modifier : 0);
        }
        if (happiness < 0)
            happiness = 0;
        else if (happiness > 8)
            happiness = 8;
    }

    public void changeFood(int delta) {
        // TODO
    }

    public void modifyResourceProduction(int delta) {
        resourceProduction += delta;
    }

    public void modifyScienceProduction(int delta) {
        scienceProduction += delta;
    }

    public void modifyCultureProduction(int delta) {
        cultureProduction += delta;
    }

    public void modifyMilitaryStrength(int delta) {
        militaryStrength += delta;
    }


    public int getWorkersOnCard(BuildingCard card)
    {
        // TODO
        return 0;
    }

    public void formArmies() {
        if (tactic == null)
        {
            normalArmies = 0;
            obsoleteArmies = 0;
        }
        // TODO - calculate normalArmies and obsoleteArmies
    }

    public int getTacticsBonus() {

        if (tactic == null) return 0;

        int result = normalArmies * tactic.getNormalBonus() + obsoleteArmies * tactic.getObsoleteBonus();

        // Air force bonus
        if (result > 0)
        {
            int remainingAirForce = getWorkersOnCard(Cards.AIR_FORCES);
            if (remainingAirForce > 0)
            {
                // Air force bonus for modern armies
                int bonusAirForces = Math.min(remainingAirForce, normalArmies);
                result += bonusAirForces * tactic.getNormalBonus();

                remainingAirForce -= bonusAirForces;

                // Air force bonus for obsolete armies
                bonusAirForces = Math.min(remainingAirForce, obsoleteArmies);
                result += bonusAirForces * tactic.getObsoleteBonus();
            }
        }

        return result;
    }

    public void modifyAdditionalMilitaryActions(int delta) {
        additionalMilitaryActions += delta;
    }

    public void modifyAdditionalCivilActions(int delta) {
        additionalCivilActions += delta;
    }

    public void gainBlueTokens(int delta) {
        blueBank += delta;
    }

    public void modifyColonizationBonus(int delta) {
        colonizationBonus += delta;
    }

    public int getCivilHandSize() {
        return government.getMaxCivilActions() + additionalCivilActions
                + (wonders.contains(Cards.LIBRARY_OF_ALEXANDRIA) ? 1 : 0);
    }

    public int getMilitaryHandSize() {
        return government.getMaxMilitaryActions() + additionalMilitaryActions
                + (wonders.contains(Cards.LIBRARY_OF_ALEXANDRIA) ? 1 : 0);
    }

    // Probably this should be refactored to a derived value
    public int getMilitaryStrength() {
        int result = militaryStrength;
        if (wonders.contains(Cards.GREAT_WALL)) {
            result += getWorkersOnCard(Cards.WARRIORS);
            result += getWorkersOnCard(Cards.SWORDSMEN);
            result += getWorkersOnCard(Cards.RIFLEMEN);
            result += getWorkersOnCard(Cards.MODERN_INFANTRY);
            result += getWorkersOnCard(Cards.CANNON);
            result += getWorkersOnCard(Cards.ROCKETS); // :)
        }
        return result;
    }

    public boolean isCardBuilt(WonderCard wonderCard) {
        return wonders.contains(wonderCard);
    }

    public void setRecalcHappiness() {
        recalcHappiness = true;
    }

    public void modifyHappinessSource(HappinessSource happinessSource, int sign) {
        Integer current = happinessSources.get(happinessSource);
        happinessSources.put(happinessSource, current == null ? sign : current + sign);
        setRecalcHappiness();
    }


    public void addHappinessSource(HappinessSource happinessSource) {
        modifyHappinessSource(happinessSource, 1);
    }

    public void removeHappinessSource(HappinessSource happinessSource) {
        modifyHappinessSource(happinessSource, -1);
    }
}
