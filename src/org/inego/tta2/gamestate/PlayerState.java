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
import org.inego.tta2.gamestate.culture.BuildingCultureProductionSource;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.culture.TheaterCultureProductionSource;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Inego on 16.08.2016.
 */
public class PlayerState {

    private int foodProduction;
    private int cultureProduction;
    private int scienceProduction;
    private int militaryStrength;

    private Map<HappinessSource, Integer> happinessSources = new HashMap<>();
    private Map<CultureProductionSource, Integer> cultureProductionSources = new HashMap<>();

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
    private boolean recalcResourceProduction;
    private int resourceProduction;
    private boolean recalcCultureProduction;

    public PlayerState() {
        yellowBank = 18;
        recalcHappiness = false;
        recalcResourceProduction = false;
        recalcCultureProduction = false;
        workerPool = 1;
        tactic = null;
        government = Cards.DESPOTISM;
        wonders = new LinkedHashSet<>();
    }

    public int getFoodProduction() {
        return foodProduction;
    }

    public int getResourceProduction() {
        if (recalcResourceProduction)
            recalculateResourceProduction();
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
            calculateHappiness();
        return happiness;
    }

    private void calculateHappiness() {
        happiness = 0;

        boolean stPeters = isCardBuilt(Cards.ST_PETERS_BASILICA);
        int baseValue;

        for (Entry<HappinessSource, Integer> happinessSourceKV : happinessSources.entrySet()) {
            Integer qty = happinessSourceKV.getValue();
            if (qty.equals(0)) continue;
            HappinessSource happinessSource = happinessSourceKV.getKey();
            baseValue = happinessSource.getValue(this);

            if (stPeters && baseValue > 0)
                baseValue++;

            happiness += qty * baseValue;
        }
        if (happiness < 0)
            happiness = 0;
        else if (happiness > 8)
            happiness = 8;
    }

    private void recalculateResourceProduction() {
        // TODO calculate resource production
        // TODO best mine bonus from Transcontinental RR
    }

    public void changeFood(int delta) {
        // TODO change food?
    }

    public void modifyResourceProduction(int delta) {
    }

    public void modifyScienceProduction(int delta) {
        scienceProduction += delta;
    }

    public void setRecalcCultureProduction() {
        recalcCultureProduction = true;
    }

    private void calculateCultureProduction() {

        cultureProduction = 0;

        boolean hollywood = isCardBuilt(Cards.HOLLYWOOD);
        boolean internet = isCardBuilt(Cards.INTERNET);

        for (Entry<CultureProductionSource, Integer> cultureProductionSourceKV : cultureProductionSources.entrySet()) {
            Integer qty = cultureProductionSourceKV.getValue();
            if (qty == 0)
                continue;
            CultureProductionSource cultureProductionSource = cultureProductionSourceKV.getKey();
            int baseValue = cultureProductionSource.getValue();
            int modifier = 0
                    + (hollywood && (cultureProductionSource instanceof TheaterCultureProductionSource
                            || cultureProductionSource instanceof LibraryCultureProductionSource) ? 2 * baseValue : 0)
                    + (internet && cultureProductionSource instanceof BuildingCultureProductionSource ? baseValue : 0);
            cultureProduction += qty * (baseValue + modifier);
        }

        if (internet) {
            // TODO on science building change recalc culture production
            // TODO on military building change recalc culture production
            cultureProduction += getBuildingScienceOutput() + getBuildingMilitaryOutput();
        }

        if (isCardBuilt(Cards.FIRST_SPACE_FLIGHT)) {
            // TODO FSF - add sum of tech card levels
            // TODO FSF - on build tech set recalc CProd
        }

        if (isCardBuilt(Cards.FAST_FOOD_CHAINS)) {
            cultureProduction += 2 * (getFarms() + getMines()) + getUrbanBuildings() + getMilitaryUnits();
            // TODO  FFC - recalc CP on modify farm / mine / urban / mil building
        }

        recalcCultureProduction = false;
    }

    private int getMilitaryUnits() {
        // TODO get workers on military cards
        return 0;
    }

    private int getUrbanBuildings() {
        // TODO get workers on urban buildings
        return 0;
    }

    private int getMines() {
        // TODO get workers on mines cards
        return 0;
    }

    private int getFarms() {
        // TODO get workers on farms cards
        return 0;
    }

    private int getBuildingMilitaryOutput() {
        // TODO get military building output
        return 0;
    }

    private int getBuildingScienceOutput() {
        // TODO get building science output
        return 0;
    }

    public int getCultureProduction() {
        if (recalcCultureProduction) {
            calculateCultureProduction();
        }
        return cultureProduction;
    }

    public void modifyMilitaryStrength(int delta) {
        militaryStrength += delta;
    }


    public int getWorkersOnCard(BuildingCard card)
    {
        // TODO get workers on card
        return 0;
    }

    public void formArmies() {
        if (tactic == null)
        {
            normalArmies = 0;
            obsoleteArmies = 0;
        }
        // TODO calculate normalArmies and obsoleteArmies
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

    public boolean wasLeaderReplaced() {
        // TODO the flag if a leader was replaced this turn
        return false;
    }

    public void setRecalcResourceProduction() {
        recalcResourceProduction = true;
    }

    public void addCultureProductionSource(CultureProductionSource cultureProductionSource) {
        modifyCultureProductionSource(1, cultureProductionSource);
    }

    public void modifyCultureProductionSource(int sign, CultureProductionSource cultureProductionSource) {
        Integer current = cultureProductionSources.get(cultureProductionSource);
        cultureProductionSources.put(cultureProductionSource, current == null ? sign : current + sign);
        setRecalcCultureProduction();
    }
}
