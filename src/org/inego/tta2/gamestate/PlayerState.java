package org.inego.tta2.gamestate;

import org.inego.tta2.QuantityHashMap;
import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.CivilCard;
import org.inego.tta2.cards.civil.CivilCardKind;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.lab.LabCard;
import org.inego.tta2.cards.civil.leader.FrederickBarbarossaCard;
import org.inego.tta2.cards.civil.leader.HomerCard;
import org.inego.tta2.cards.civil.leader.LeaderCard;
import org.inego.tta2.cards.civil.library.LibraryCard;
import org.inego.tta2.cards.civil.tech.civil.CivilTechCard;
import org.inego.tta2.cards.civil.tech.colonization.ColonizationTechCard;
import org.inego.tta2.cards.civil.tech.construction.ConstructionTechCard;
import org.inego.tta2.cards.civil.tech.military.MilitaryTechCard;
import org.inego.tta2.cards.civil.theater.TheaterCard;
import org.inego.tta2.cards.civil.unit.ArtilleryCard;
import org.inego.tta2.cards.civil.unit.InfantryCard;
import org.inego.tta2.cards.civil.unit.UnitCard;
import org.inego.tta2.cards.civil.unit.UnitType;
import org.inego.tta2.cards.civil.upgrade.BuildingChainElement;
import org.inego.tta2.cards.civil.wonder.WonderCard;
import org.inego.tta2.cards.military.MilitaryCard;
import org.inego.tta2.cards.military.colony.ColonyCard;
import org.inego.tta2.cards.military.tactic.TacticCard;
import org.inego.tta2.gamestate.choice.ElectLeaderChoice;
import org.inego.tta2.gamestate.choice.action.ActionPhaseChoice;
import org.inego.tta2.gamestate.choice.action.ChangeGovernmentChoice;
import org.inego.tta2.gamestate.choice.action.IncreasePopulationChoice;
import org.inego.tta2.gamestate.choice.action.RevolutionChoice;
import org.inego.tta2.gamestate.comparison.PlayerComparison;
import org.inego.tta2.gamestate.comparison.TopNumber;
import org.inego.tta2.gamestate.choice.leader.ColumbusColonizationChoice;
import org.inego.tta2.gamestate.culture.*;
import org.inego.tta2.gamestate.happiness.GovernmentHappinessSource;
import org.inego.tta2.gamestate.happiness.HappinessSource;
import org.inego.tta2.gamestate.happiness.TempleHappinessSource;
import org.inego.tta2.gamestate.happiness.WonderHappinessSource;
import org.inego.tta2.gamestate.point.HomerReplaced;
import org.inego.tta2.gamestate.science.*;
import org.inego.tta2.gamestate.tactics.Composition;
import org.inego.tta2.gamestate.tactics.Utils;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 */
public class PlayerState {

    private static final CivilCardKind[] GREAT_WALL_UNITS = {CivilCardKind.INFANTRY, CivilCardKind.ARTILLERY};

    private GameState gameState;

    private int foodProduction;
    private int cultureProduction;
    private int scienceProduction;

    private int militaryStrength; // Derived
    private int militaryStrengthBase;

    private QuantityHashMap<HappinessSource> happinessSources = new QuantityHashMap<>();
    private QuantityHashMap<CultureProductionSource> cultureProductionSources = new QuantityHashMap<>();
    private QuantityHashMap<IScienceProductionSource> scienceProductionSources = new QuantityHashMap<>();

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
    private WonderCard currentWonder;
    private Set<WonderCard> wonders = new LinkedHashSet<>();
    private int builtStages;

    // Tactics
    private TacticCard tactic;
    private int modernArmies;
    private int obsoleteArmies;

    private int culturePoints;
    private int sciencePoints;

    private int colonizationBonus;

    private boolean recalcHappiness;
    private boolean recalcResourceProduction;
    private boolean recalcCultureProduction;
    private boolean recalcMilitary;
    private boolean recalcScienceProduction;

    private int resourceProduction;
    private LeaderCard leader;

    private boolean leaderSpecialActionAvailable;

    private int food;
    private int resources;

    private int spentCivilActions;
    private int availableCivilActions;
    private int militaryProductionBonus;
    private int leaderMilitaryProductionBonus;
    private int availableMilitaryActions;

    private int waitingTurns;

    private LinkedList<CivilCard> civilHand;
    private LinkedList<MilitaryCard> militaryHand;

    private Set<ITechnologyCard> discoveredTechs = new HashSet<>();

    /**
     * A map of building chains. Building chains are represented by the <b>latest</b> discovered card of its kind,
     * in order to make ordered inserts fastest (since incremental age discoveries are the most common case).
     * Because of that, building chains must be iterated backwards (by using {@link BuildingChainElement#prev} property.
     */
    private Map<CivilCardKind, BuildingChainElement> buildingChains;

    private Map<BuildingCard, BuildingChainElement> discoveredBuildings;

    private LinkedList<ColonyCard> colonies = new LinkedList<>();


    public PlayerState(GameState gameState) {

        this.gameState = gameState;

        // From 1 Warrior:
        militaryStrengthBase = 1;
        militaryStrength = 1;

        militaryProductionBonus = 0;
        leaderMilitaryProductionBonus = 0;

        yellowBank = 18;
        recalcHappiness = false;
        recalcResourceProduction = false;
        recalcCultureProduction = false;
        recalcScienceProduction = false;

        availableCivilActions = 0;
        spentCivilActions = 0;

        food = 0;
        resources = 0;

        builtStages = 0;

        workerPool = 1;
        tactic = null;
        government = Cards.DESPOTISM;
        leader = null;

        civilHand = new LinkedList<>();
        militaryHand = new LinkedList<>();

        buildingChains = new EnumMap<>(CivilCardKind.class);
        discoveredBuildings = new HashMap<>();

        discoverBuilding(Cards.WARRIORS).qty = 1;
        discoverBuilding(Cards.AGRICULTURE).qty = 2;
        discoverBuilding(Cards.BRONZE).qty = 2;
        discoverBuilding(Cards.PHILOSOPHY).qty = 1;
        discoverBuilding(Cards.RELIGION);

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
        return culturePoints;
    }

    public int getHappiness() {
        if (recalcHappiness)
            calculateHappiness();
        return happiness;
    }

    private void calculateHappiness() {
        happiness = 0;
        iterateHappiness((happinessSource, value, qty) -> happiness += qty * value);
        if (happiness < 0)
            happiness = 0;
        else if (happiness > 8)
            happiness = 8;
        recalcHappiness = false;
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
            // TODO on science building and Internet change recalc culture production
            // TODO on military building and Internet change recalc culture production
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
        else if (leader == Cards.WILLIAM_SHAKESPEARE) {
            int libraries = 0;
            int theaters = 0;
            for (Entry<CultureProductionSource, Integer> entry : cultureProductionSources.entrySet()) {
                if (entry.getKey() instanceof LibraryCultureProductionSource)
                    libraries += entry.getValue();
                else if (entry.getKey() instanceof TheaterCultureProductionSource)
                    theaters += entry.getValue();
            }
            cultureProduction += 2 * Math.min(libraries, theaters);
        }
        else if (leader == Cards.JAMES_COOK && !colonies.isEmpty()) {
            cultureProduction += colonies.size() + 1;
        }
        else if (leader == Cards.JS_BACH) {
            for (Entry<CultureProductionSource, Integer> entry : cultureProductionSources.entrySet()) {
                if (entry.getKey() instanceof TheaterCultureProductionSource)
                    cultureProduction += entry.getValue();
            }
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
        if (recalcCultureProduction)
            calculateCultureProduction();
        return cultureProduction;
    }

    public int getScienceProduction() {
        if (recalcScienceProduction)
            calculateScienceProduction();
        return scienceProduction;
    }

    private void calculateScienceProduction() {
        scienceProduction = 0;

        for (Entry<IScienceProductionSource, Integer> entry : scienceProductionSources.entrySet()) {
            scienceProduction += entry.getValue() * entry.getKey().getScienceProductionValue();
        }

        if (leader == Cards.LEONARDO_DA_VINCI) {
            int bestLevel = 0;
            for (IScienceProductionSource scienceProductionSource : scienceProductionSources.keySet()) {
                if (scienceProductionSource instanceof LibraryCard || scienceProductionSource instanceof LabCard) {
                    if (scienceProductionSource.getAge() > bestLevel)
                        bestLevel = scienceProductionSource.getAge();
                }
            }
            scienceProduction += bestLevel;
        }

        recalcScienceProduction = false;
    }

    public void modifyMilitaryStrengthBase(int delta) {
        militaryStrengthBase += delta;
        setRecalcMilitaryStrength();
    }

    public void formArmies() {

        setRecalcMilitaryStrength();

        if (tactic == null)
        {
            modernArmies = 0;
            obsoleteArmies = 0;
            return;
        }

        // TODO refactor getComposition to using UnitCard.getUnitType
        Composition composition = getComposition(tactic.getAge());

        // Modern armies

        int infantry = tactic.getInfantry();
        int cavalry = tactic.getCavalry();
        int artillery = tactic.getArtillery();

        if (leader == Cards.GENGHIS_KHAN)
            modernArmies = Utils.getGenghisKhanMaxArmies(cavalry, infantry, composition.modernCavalry, composition.modernInfantry);
        else {
            modernArmies = infantry > 0 ? composition.modernInfantry / infantry : 1000 /* arbitrary big number */;
            if (modernArmies > 0 && cavalry > 0)
                modernArmies = Math.min(modernArmies, composition.modernCavalry / cavalry);
        }

        if (modernArmies > 0 && artillery > 0)
            modernArmies = Math.min(modernArmies, composition.modernArtillery / artillery);

        // Units not taking part in modern armies can take part in obsolete armies
        if (infantry > 0)
            composition.obsoleteInfantry += (composition.modernInfantry - modernArmies * infantry);
        if (cavalry > 0)
            composition.obsoleteCavalry += (composition.modernCavalry - modernArmies * cavalry);
        if (artillery > 0)
            composition.obsoleteArtillery += (composition.modernArtillery - modernArmies * artillery);

        if (leader == Cards.GENGHIS_KHAN)
            obsoleteArmies = Utils.getGenghisKhanMaxArmies(cavalry, infantry, composition.obsoleteCavalry, composition.obsoleteInfantry);
        else {
            obsoleteArmies = infantry > 0 ? composition.obsoleteInfantry / infantry : 1000 /* arbitrary big number */;
            if (obsoleteArmies > 0 && cavalry > 0)
                obsoleteArmies = Math.min(obsoleteArmies, composition.obsoleteCavalry / cavalry);
        }

        if (obsoleteArmies > 0 && artillery > 0)
            obsoleteArmies = Math.min(obsoleteArmies, composition.obsoleteArtillery / artillery);
    }

    private void iterateUnitKinds(CivilCardKind[] kinds, Consumer<BuildingChainElement> consumer)
    {
        for (CivilCardKind kind : kinds) {
            Iterator<BuildingChainElement> chainIterator = getChainIterator(kind);
            while (chainIterator.hasNext()) {
                BuildingChainElement chainElement = chainIterator.next();
                if (chainElement.qty > 0)
                    consumer.accept(chainElement);
            }
        }
    }


    public Composition getComposition(int age) {

        Composition composition = new Composition();

        iterateUnitKinds(UnitCard.TACTIC_KINDS, element -> ((UnitCard)element.buildingCard).addToComposition(composition, element.qty, age));

        return composition;

    }

    public Iterator<BuildingChainElement> getChainIterator(CivilCardKind kind) {

        return new Iterator<BuildingChainElement>() {

            private BuildingChainElement next = buildingChains.get(kind);

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public BuildingChainElement next() {
                BuildingChainElement result = next;
                next = next.prev;
                return result;
            }
        };
    }

    public int getTacticsBonus() {

        if (tactic == null) return 0;

        int result = modernArmies * tactic.getNormalBonus() + obsoleteArmies * tactic.getObsoleteBonus();

        // Air force bonus
        if (result > 0)
        {
            BuildingChainElement chainElement = discoveredBuildings.get(Cards.AIR_FORCES);

            int remainingAirForce = chainElement == null ? 0 : chainElement.qty;

            if (remainingAirForce > 0)
            {
                // Air force bonus for modern armies
                int bonusAirForces = Math.min(remainingAirForce, modernArmies);
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
        // TODO increase available military actions?
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

        if (recalcMilitary)
            calculateMilitaryStrength();

        return militaryStrength;
    }

    private void calculateMilitaryStrength() {

        militaryStrength = militaryStrengthBase;

        if (wonders.contains(Cards.GREAT_WALL)) {
            iterateUnitKinds(GREAT_WALL_UNITS, element -> {militaryStrength += element.qty;});
        }

        militaryStrength += getTacticsBonus();

        if (leader == Cards.ALEXANDER) {
            iterateUnitKinds(UnitCard.ALL_KINDS, element -> {militaryStrength += element.qty;});
        }
        else if (leader == Cards.JOAN_OF_ARC) {
            iterateHappiness((happinessSource, value, qty) -> {
                if (happinessSource instanceof TempleHappinessSource || happinessSource instanceof GovernmentHappinessSource)
                    militaryStrength += value * qty;
            });
        }
        else if (leader == Cards.NAPOLEON_BONAPARTE) {
            Set<UnitType> types = EnumSet.noneOf(UnitType.class);

            for (CivilCardKind kind : UnitCard.ALL_KINDS) {
                Iterator<BuildingChainElement> chainIterator = getChainIterator(kind);
                while (chainIterator.hasNext()) {
                    BuildingChainElement chainElement = chainIterator.next();
                    if (chainElement.qty > 0) {
                        types.add(((UnitCard)chainElement.buildingCard).getUnitType());
                        break;
                    }
                }
            }

            militaryStrength += 2 * types.size();
        }
        recalcMilitary = false;
    }

    public boolean isCardBuilt(WonderCard wonderCard) {
        return wonders.contains(wonderCard);
    }

    public void setRecalcHappiness() {
        recalcHappiness = true;
    }

    public void modifyHappinessSource(HappinessSource happinessSource, int sign) {
        happinessSources.delta(happinessSource, sign);
        setRecalcHappiness();

        if (leader == Cards.MICHELANGELO)
            setRecalcCultureProduction();
        else if (leader == Cards.JOAN_OF_ARC)
            setRecalcMilitaryStrength();
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

    public void setRecalcScienceProduction() {
        recalcScienceProduction = true;
    }

    public void addCultureProductionSource(CultureProductionSource cultureProductionSource) {
        modifyCultureProductionSource(1, cultureProductionSource);
    }

    public void modifyCultureProductionSource(int sign, CultureProductionSource cultureProductionSource) {
        cultureProductionSources.delta(cultureProductionSource, sign);
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
                gameState.proceedTo(HomerReplaced.HOMER_REPLACED, HomerCard.ATTACH_HAPPY_FACE, ElectLeaderChoice.GET_BACK_AP);
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

        if (leader == Cards.GENGHIS_KHAN) {
            checkGenghisCultureBonus();
        }

        discardExcessMilitaryCards();
        if (!isUprising()) {
            handleProductionPhase();
        }
        drawMilitaryCards();
        resetActions();
        gameState.endPlayerTurn();
    }

    private void checkGenghisCultureBonus() {
        if (isAmongTop(TopNumber.TWO, PlayerComparison.MILITARY_STRENGTH))
            gainCulturePoints(3);
    }

    public boolean isAmongTop(TopNumber topNumber, Comparator<PlayerState> comparator) {
        return gameState.isAmongTop(this, topNumber, comparator);
    }

    public void gainCulturePoints(int value) {
        culturePoints += value;
    }

    private void resetActions() {
        availableCivilActions = getCivilActionsTotal();
        availableMilitaryActions = getMilitaryActionsTotal();
    }

    private int getMilitaryActionsTotal() {
        return maxMilitaryActions + additionalMilitaryActions;
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

            drawMilitaryCards(cardsToDraw);

        }

    }

    public void drawMilitaryCards(int cardsToDraw) {
        if (cardsToDraw > 0) {
            addMilitaryCards(gameState.drawMilitaryCards(cardsToDraw));
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

        for (CivilCard civilCard : civilHand) {
            if (civilCard instanceof GovernmentCard) {
                GovernmentCard governmentCard = (GovernmentCard) civilCard;
                // Peaceful discover
                int researchCost = governmentCard.getResearchCost(this);
                if (sciencePoints >= researchCost) {
                    gameState.addChoice(new ChangeGovernmentChoice(governmentCard, researchCost));
                }
                // Revolution
                researchCost = governmentCard.getRevolutionCost();
                if (researchCost >= sciencePoints) {
                    if (leader == Cards.MAXIMILIEN_ROBESPIERRE) {
                        int militaryActionsTotal = getMilitaryActionsTotal();
                        if (availableMilitaryActions >= militaryActionsTotal)
                            gameState.addChoice(new RevolutionChoice(governmentCard, researchCost, militaryActionsTotal, true));
                    }
                    else {
                        // Standard revolution, spend all civil actions
                        int civilActionsTotal = getCivilActionsTotal();
                        if (getAvailableCivilActions() >= civilActionsTotal)
                            gameState.addChoice(new RevolutionChoice(governmentCard, researchCost, civilActionsTotal, false));
                    }
                }
            }
        }

        if (leader == Cards.FREDERICK_BARBAROSSA) {
            if (availableMilitaryActions > 0) {
                int foodCost = getIncreasePopulationCost() - 1;
                if (foodCost <= food) {
                    for (ITechnologyCard discoveredTech : discoveredTechs) {
                        if (discoveredTech instanceof UnitCard) {
                            int buildingCost = ((UnitCard) discoveredTech).getBuildingCost(this) - 1;
                            if (buildingCost <= resources) {
                                gameState.addChoice(new FrederickBarbarossaCard.BuildUnitChoice((UnitCard) discoveredTech, foodCost, buildingCost));
                            }
                        }
                    }
                }
            }
        }
        else if (leader == Cards.JS_BACH) {
            // TODO Bach!
        }

        gameState.addChoice(ActionPhaseChoice.END);

    }

    private int getCivilActionsTotal() {
        // TODO get civil actions total
        return maxCivilActions + additionalCivilActions;
    }

    private int getIncreasePopulationCost() {
        // TODO get increase population cost
        return 1;
    }

    public void increasePopulation(int populationProductionCost) {
        loseResources(populationProductionCost);
        gainPopulation(1);
    }

    public void gainPopulation(int value) {
        // TODO gain population
        workerPool += value;
    }

    private void loseResources(int value) {
        // TODO lose resources (refactor + return tokens to the blue bank)
        resources -= value;
    }

    public void gainResources(int value) {
        // TODO gain resources
        resources += value;
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
            if (stPeters && (baseValue > 0 && happinessSource != WonderHappinessSource.ST_PETERS))
                baseValue++;
            handler.handle(happinessSource, baseValue, qty);
        }
    }

    public void build(BuildingCard card) {
        // TODO inc built cards?
        card.assignWorker(1, this);

        discoveredBuildings.get(card).qty++;

        if (card instanceof UnitCard) {
            formArmies();
        }
    }

    public Set<WonderCard> getWonders() {
        return wonders;
    }

    public void setMilitaryTactic(TacticCard tactic) {
        this.tactic = tactic;
        formArmies();
    }

    public void takeCard(CivilCard card) {

        // TODO take card

        if (card instanceof WonderCard) {
            currentWonder = (WonderCard) card;
        }
    }

    public WonderCard getCurrentWonder() {
        return currentWonder;
    }

    public int getRemainingWonderStages() {
        if (currentWonder == null)
            return 0;
        return currentWonder.getStages().length - builtStages;
    }

    public void buildWonderStages(int numberOfStages) {

        int[] stages = currentWonder.getStages();

        // TODO build wonder stages

        if (stages.length == builtStages + numberOfStages) {

            // TODO free workers from built stages

            wonders.add(currentWonder);
            currentWonder.onBuild(this);
            currentWonder = null;
            builtStages = 0;

        }
        else {
            // TODO put worker on stages
        }
    }

    public int getModernArmies() {
        return modernArmies;
    }

    public int getObsoleteArmies() {
        return obsoleteArmies;
    }

    public void debugClearUnits() {
        iterateUnitKinds(UnitCard.ALL_KINDS, element -> {
            while (element.qty > 0)
                disband(element.buildingCard);
        });
    }

    private void disband(BuildingCard card) {
        card.assignWorker(-1, this);

        discoveredBuildings.get(card).qty--;

        if (card instanceof UnitCard) {
            formArmies();
        }

        // TODO disband - return pop
    }

    public void modifyScienceProductionSource(int sign, IScienceProductionSource scienceProductionSource) {
        scienceProductionSources.delta(scienceProductionSource, sign);
    }

    public void addScienceProductionSource(IScienceProductionSource scienceProductionSource) {
        modifyScienceProductionSource(1, scienceProductionSource);
    }

    public void discover(ITechnologyCard technologyCard) {

        // TODO discover technology

        if (technologyCard instanceof BuildingCard)
            discoverBuilding((BuildingCard)technologyCard);

        if (leader == Cards.LEONARDO_DA_VINCI)
            gainResources(1);
    }

    /**
     * Inserts a new building card into the appropriate building chain according to its age
     * @param buildingCard The building card
     */
    private BuildingChainElement discoverBuilding(BuildingCard buildingCard) {

        BuildingChainElement newChainElement = new BuildingChainElement(buildingCard, 0);

        discoveredBuildings.put(buildingCard, newChainElement);

        CivilCardKind kind = buildingCard.getKind();

        BuildingChainElement currentChainTop = buildingChains.get(kind);

        if (currentChainTop == null)
            buildingChains.put(kind, newChainElement);
        else {
            int age = buildingCard.getAge();
            if (age > currentChainTop.getAge())
            {
                currentChainTop.next = newChainElement;
                newChainElement.prev = currentChainTop;
                buildingChains.put(kind, newChainElement);
            }
            else {
                BuildingChainElement previous = currentChainTop;
                currentChainTop = currentChainTop.prev;
                while (currentChainTop != null) {
                    if (age > currentChainTop.getAge()) {
                        currentChainTop.next = newChainElement;
                        previous.prev = newChainElement;
                        newChainElement.prev = currentChainTop;
                        newChainElement.next = previous;
                        return newChainElement;
                    }
                    previous = currentChainTop;
                    currentChainTop = currentChainTop.prev;
                }
                // The new element is the first
                previous.prev = newChainElement;
                newChainElement.next = previous;
            }
        }
        return newChainElement;
    }


    public void setWaitingTurns(int waitingTurns) {
        this.waitingTurns = waitingTurns;
    }

    /**
     * Returns the number of turns this player has to wait until he becomes the current player.
     * @return Number of turns to wait, {@code 0} if the player is the current player
     */
    public int getWaitingTurns() {
        return waitingTurns;
    }

    @Override
    public String toString() {
        if (gameState != null) {
            int orderNo = gameState.getIndex(this);
            if (orderNo != -1) {
                return "P" + orderNo;
            }
        }
        return super.toString();
    }

    public void addColumbusColonizationChoices() {
        for (MilitaryCard militaryCard : militaryHand) {
            if (militaryCard instanceof ColonyCard) {
                gameState.addChoice(new ColumbusColonizationChoice((ColonyCard) militaryCard));
            }
        }
    }

    public void colonize(ColonyCard colony) {
        // TODO colonize
        colonies.add(colony);

        if (leader == Cards.JAMES_COOK)
            setRecalcCultureProduction();

        colony.immediateBonus(this);
        colony.onGain(1, this);
    }

    public void loseColony(ColonyCard colony) {
        // TODO lose colony
        colonies.remove(colony);

        if (leader == Cards.JAMES_COOK)
            setRecalcCultureProduction();

        colony.onGain(-1, this);
    }

    public void payFood(int value) {
        // TODO pay food
    }

    public void payResources(int value) {
        // TODO pay resources
    }

    public void spendMilitaryActions(int value) {
        availableMilitaryActions -= value;
    }

    public boolean hasTheaters() {
        return has(CivilCardKind.THEATER);
    }

    public boolean hasLibraries() {
        return has(CivilCardKind.LIBRARY);
    }

    private boolean has(CivilCardKind kind) {

        Iterator<BuildingChainElement> chainIterator = getChainIterator(kind);
        while (chainIterator.hasNext())
        {
            BuildingChainElement chainElement = chainIterator.next();
            if (chainElement.qty > 0)
                return true;
        }

        return false;
    }

    public void gainSciencePoints(int value) {
        sciencePoints += value;
    }

    public void modifyBlueTokens(int value) {
        if (value > 0)
            gainBlueTokens(value);
        else
            loseBlueTokens(-value);
    }

    private void loseBlueTokens(int value) {
        // TODO lose blue tokens
    }

    public void modifyYellowTokens(int value) {
        if (value > 0)
            gainYellowTokens(value);
        else
            loseYellowTokens(-value);
    }

    private void loseYellowTokens(int value) {
        // TODO lose yellow tokens
    }

    public void gainFood(int value) {
        // TODO gain food
        food += value;
    }

    public void loseCivilCard(CivilCard card) {
        civilHand.remove(card);
    }

    public void paySciencePoints(int cost) {
        sciencePoints -= cost;
    }

    public void setGovernment(GovernmentCard newGovernment) {
        this.government = newGovernment;
    }

    public void payMilitaryActions(int cost) {
        availableMilitaryActions -= cost;
    }

    public void discoverGovernment(GovernmentCard government, int scienceCost) {
        paySciencePoints(scienceCost);
        setGovernment(government);
        loseCivilCard(government);
    }

    public boolean hasDiscovered(BuildingCard buildingCard) {
        return discoveredBuildings.containsKey(buildingCard);
    }


    @FunctionalInterface
    interface IHappinessSourceHandler {
        void handle(HappinessSource happinessSource, int value, int qty);
    }

}
