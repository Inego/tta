package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.leader.HomerCard;
import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.cards.civil.tech.civil.CivilTechCard;
import org.inego.tta2.cards.civil.tech.colonization.ColonizationTechCard;
import org.inego.tta2.cards.civil.tech.construction.ConstructionTechCard;
import org.inego.tta2.cards.civil.tech.military.MilitaryTechCard;
import org.inego.tta2.cards.civil.theater.TheaterCard;
import org.inego.tta2.cards.civil.wonder.WonderCard;
import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.cards.military.tactic.TacticCard;
import org.inego.tta2.gamestate.choice.ElectLeaderChoice;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;
import org.inego.tta2.gamestate.choice.action.IncreasePopulationChoice;
import org.inego.tta2.gamestate.culture.BuildingCultureProductionSource;
import org.inego.tta2.gamestate.culture.CultureProductionSource;
import org.inego.tta2.gamestate.culture.LibraryCultureProductionSource;
import org.inego.tta2.gamestate.culture.TheaterCultureProductionSource;
import org.inego.tta2.gamestate.happiness.HappinessSource;
import org.inego.tta2.gamestate.happiness.TempleHappinessSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;
import org.inego.tta2.gamestate.point.GamePoint;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Inego on 16.08.2016.
 */
public class PlayerState {

    private GameState gameState;

    private int foodProduction;
    private int cultureProduction;
    private int scienceProduction;

    private int militaryStrength; // Derived
    private int militaryStrengthBase;

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
    private LeaderCard leader;
    private boolean leaderSpecialActionAvailable;

    private int resources;

    private int spentCivilActions;
    private int availableCivilActions;
    private int militaryProductionBonus;
    private int leaderMilitaryProductionBonus;
    private int availableMilitaryActions;
    private boolean recalcMilitary;


    public PlayerState(GameState gameState) {

        this.gameState = gameState;

        militaryProductionBonus = 0;
        leaderMilitaryProductionBonus = 0;
        militaryStrength = 1; // From 1 warrior
        militaryStrengthBase = 0;

        yellowBank = 18;
        recalcHappiness = false;
        recalcResourceProduction = false;
        recalcCultureProduction = false;
        recalcMilitary = false;

        availableCivilActions = 0;
        spentCivilActions = 0;

        workerPool = 1;
        tactic = null;
        government = Cards.DESPOTISM;
        leader = null;

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
        iterateHappiness((happinessSource, value, qty) -> { happiness += qty * value; });
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

        boolean hollywood = wonders.contains(Cards.HOLLYWOOD);
        boolean internet = wonders.contains(Cards.INTERNET);

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

        if (wonders.contains(Cards.FIRST_SPACE_FLIGHT)) {
            // TODO FSF - add sum of tech card levels
            // TODO FSF - on build tech set recalc CProd
        }

        if (wonders.contains(Cards.FAST_FOOD_CHAINS)) {
            cultureProduction += 2 * (getFarms() + getMines()) + getUrbanBuildings() + getMilitaryUnits();
            // TODO  FFC - recalc CP on modify farm / mine / urban / mil building
        }

        if (leader == Cards.MICHELANGELO) {
            iterateHappiness((happinessSource, value, qty) -> {
                if (happinessSource == HappinessSource.THEATER
                        || happinessSource instanceof TempleHappinessSource
                        || happinessSource instanceof WonderHappinessSource)
                    cultureProduction += qty * value;
            });
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

    public void modifyMilitaryStrengthBase(int delta) {
        militaryStrengthBase += delta;
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

    public int getMilitaryStrength() {

        if (recalcMilitary) {
            calculateMilitaryStrength();
        }


        return militaryStrength;
    }

    private void calculateMilitaryStrength() {

        militaryStrength = militaryStrengthBase;

        if (wonders.contains(Cards.GREAT_WALL)) {
            militaryStrength += getWorkersOnCard(Cards.WARRIORS);
            militaryStrength += getWorkersOnCard(Cards.SWORDSMEN);
            militaryStrength += getWorkersOnCard(Cards.RIFLEMEN);
            militaryStrength += getWorkersOnCard(Cards.MODERN_INFANTRY);
            militaryStrength += getWorkersOnCard(Cards.CANNON);
            militaryStrength += getWorkersOnCard(Cards.ROCKETS); // :)
        }

        if (leader == Cards.ALEXANDER) {
            // TODO Alexander - add total number of military units
        }

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

        if (leader == Cards.MICHELANGELO) setRecalcCultureProduction();
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

    public LeaderCard getLeader() {
        return leader;
    }

    public void useJuliusCaesarAction() {
        leaderSpecialActionAvailable = false;
        // Repeat political phase
        gameState.startPoliticalPhase();
    }

    public void electLeader(LeaderCard newLeader) {

        if (leader != null) {
            leader.onElect(-1, this, newLeader);

            // TODO test getting 1 CA back and Homer's choice
            if (leader == Cards.HOMER && wonders.size() > 0) {
                gameState.proceedTo(GamePoint.HOMER_REPLACED, HomerCard.ATTACH_HAPPY_FACE, ElectLeaderChoice.GET_BACK_AP);
            }
            else {
                // simply give 1 CA back
                getBackCivilAP(1);
            }
        }
        newLeader.onElect(1, this, leader);
        leader = newLeader;
    }

    public void removeCurrentLeader() {
        leader.onElect(-1, this, null);
        leader = null;
    }

    public void getBackCivilAP(int i) {
        int toGetBack = Math.min(spentCivilActions, i);
        if (toGetBack > 0) {
            // TODO get back CA
        }
    }

    public void setAvailableCivilActions(int value) {
        availableCivilActions = value;
    }

    public int getAvailableCivilActions() {
        // TODO find all usages of reading available civil actions
        if (leader == Cards.HAMMURABI && leaderSpecialActionAvailable && availableMilitaryActions > 0) {
            return availableCivilActions + 1;
        }
        return availableCivilActions;
    }

    public void useCivilActions(int value) {
        // TODO find all usages of spending civil actions
        availableCivilActions -= value;
        if (availableCivilActions < 0) {
            if (leader == Cards.HAMMURABI && leaderSpecialActionAvailable && availableMilitaryActions > 0) {
                availableCivilActions++;
                availableMilitaryActions--;
                leaderSpecialActionAvailable = false;
            }
            else {
                throw new UnsupportedOperationException("Spent more civil actions than available");
            }
        }
    }


    public void setAvailableMilitaryActions(int value) {
        availableMilitaryActions = value;
    }

    public void modifyMilitaryProductionBonus(int delta) {
        militaryProductionBonus += delta;
    }

    public void setLeaderMilitaryProductionBonus(int value) {
        leaderMilitaryProductionBonus = value;
    }


    public void resolveWar() {
        // TODO resolve war
    }

    public void makeCurrentTacticsAvailable() {
        // TODO make current tactics available
    }

    public void endTurn() {
        discardExcessMilitaryCards();
        if (!isUprising()) {
            handleProductionPhase();
        }
        drawMilitaryCards();
        resetActions();
        gameState.endPlayerTurn();
    }

    private void resetActions() {
        availableCivilActions = maxCivilActions;
        availableMilitaryActions = maxMilitaryActions;
    }

    private void handleProductionPhase() {

        sciencePoints += scienceProduction;
        culturePoints += cultureProduction;

        handleCorruption();

        produceFood();

        consumeFood();

        produceResources();



    }

    private void drawMilitaryCards() {

        if (gameState.getAge() < 4) {

            int cardsToDraw = Math.min(availableMilitaryActions, 3);

            if (cardsToDraw > 0) {
                addMilitaryCards(gameState.drawMilitaryCards(cardsToDraw));
            }

        }

    }

    private void addMilitaryCards(MilitaryCard[] militaryCards) {
        // TODO add military cards
    }

    private void produceResources() {
        // TODO produce resources
    }

    private void consumeFood() {
        // TODO consume food
    }

    private void produceFood() {
        // TODO produce food
    }

    private void handleCorruption() {
        // TODO handle corruption
    }

    private boolean isUprising() {
        // TODO uprising determination
        return false;
    }

    private void discardExcessMilitaryCards() {
        // TODO discard excess military cards
    }

    public int getPopulationProductionCost() {
        // TODO pop production cost
        int result = 2;

        if (leader == Cards.MOSES) {
            result--;
        }

        if (result < 0) result = 0;

        return result;
    }

    public void addActionPhaseChoices() {

        // TODO add action phase choices

        int populationProductionCost = getPopulationProductionCost();

        if (populationProductionCost <= resources) {
            gameState.addChoice(new IncreasePopulationChoice(populationProductionCost));
        }

        gameState.addChoice(ActionPhaseChoice.PASS);

    }

    public void increasePopulation(int populationProductionCost) {
        loseResources(populationProductionCost);
        gainPopulation(1);
    }

    private void gainPopulation(int value) {
        workerPool += value;
    }

    private void loseResources(int value) {
        // TODO lose resources (refactor + return tokens to the blue bank)
        resources -= value;
    }

    public void enableLeaderSpecialAction() {
        leaderSpecialActionAvailable = true;
    }

    public boolean isLeaderSpecialActionAvailable() {
        return leaderSpecialActionAvailable;
    }

    public void addCardToHand(CivilCard takenCard) {
        // TODO add card to hand

        if (leader == Cards.ARISTOTLE && takenCard instanceof ITechnologyCard) {
            sciencePoints++;
        }

    }

    public void setRecalcMilitaryStrength() {
        recalcMilitary = true;
    }

    public void gainYellowTokens(int value) {
        // TODO gain yellow tokens
    }

    public void iterateHappiness(IHappinessSourceHandler handler) {
        boolean stPeters = wonders.contains(Cards.ST_PETERS_BASILICA);
        int baseValue;
        for (Entry<HappinessSource, Integer> happinessSourceKV : happinessSources.entrySet()) {
            Integer qty = happinessSourceKV.getValue();
            if (qty.equals(0))
                continue;
            HappinessSource happinessSource = happinessSourceKV.getKey();
            baseValue = happinessSource.getValue(this);
            if (stPeters && baseValue > 0)
                baseValue++;
            handler.handle(happinessSource, baseValue, qty);
        }
    }

    public void build(BuildingCard card) {
        // TODO inc built cards?
        card.assignWorker(1, this);

        // TODO build - spend resources
        // TODO build - spend pop
    }

    @FunctionalInterface
    interface IHappinessSourceHandler {
        void handle(HappinessSource happinessSource, int value, int qty);
    }


}
