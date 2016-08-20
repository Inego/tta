package org.inego.tta2.gamestate;

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




    private int culturePoints;
    private int sciencePoints;

    public PlayerState() {
        yellowBank = 18;
        happiness = 0;
        workerPool = 1;

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
}
