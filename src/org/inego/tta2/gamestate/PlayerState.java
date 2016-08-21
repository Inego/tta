package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.tech.civil.CivilTechCard;
import org.inego.tta2.cards.civil.tech.colonization.ColonizationTechCard;
import org.inego.tta2.cards.civil.tech.construction.ConstructionTechCard;
import org.inego.tta2.cards.civil.tech.military.MilitaryTechCard;
import org.inego.tta2.cards.military.tactic.TacticCard;

/**
 * Created by Inego on 16.08.2016.
 */
public class PlayerState {

    private int foodProduction;
    private int resourceProduction;
    private int cultureProduction;
    private int scienceProduction;
    private int militaryStrength;
    private int happiness;

    private int blueBank;
    private int yellowBank;

    private int workerPool;

    private int maxCivilActions;
    private int maxMilitaryActions;
    private int additionalMilitaryActions;
    private int additionalCivilActions;

    // Technologies
    private MilitaryTechCard militaryTech;
    private CivilTechCard civilTech;
    private ColonizationTechCard colonizationTech;
    private ConstructionTechCard constructionTech;


    // Tactics
    private TacticCard tactic;
    private int normalArmies;
    private int obsoleteArmies;

    private int culturePoints;
    private int sciencePoints;

    private int colonizationBonus;

    public PlayerState() {
        yellowBank = 18;
        happiness = 0;
        workerPool = 1;
        tactic = null;
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
        return happiness;
    }

    public void changeFood(int delta) {

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

    public void modifyHappiness(int delta) {
        happiness += delta;
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
}
