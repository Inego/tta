package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.library.LibraryCard;
import org.inego.tta2.cards.civil.unit.UnitCard;
import org.inego.tta2.cards.civil.upgrade.UpgradeDescription;
import org.inego.tta2.cards.civil.upgrade.UpgradeDescriptionFactory;
import org.inego.tta2.cards.civil.wonder.WonderCard;
import org.inego.tta2.cards.military.tactic.TacticCard;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class PlayerStateTest {

    private GameState gameState;
    private PlayerState playerState;

    @Before
    public void setUp() {
        gameState = new GameState(3);
        playerState = gameState.getPlayerState(0);
    }

    @Test
    public void testCalculateCultureProduction() {

        assertEquals(0, playerState.getCultureProduction());

        build(Cards.THEOLOGY);
        assertEquals(1, playerState.getCultureProduction());

        build(Cards.OPERA);
        assertEquals(4, playerState.getCultureProduction());

        build(Cards.OPERA);
        assertEquals(7, playerState.getCultureProduction());

        playerState.electLeader(Cards.MICHELANGELO);
        assertEquals(11, playerState.getCultureProduction());

    }

    @Test
    public void testCalculateMilitaryStrength() {
        assertEquals(1, playerState.getMilitaryStrength());

        build(Cards.WARRIORS);
        assertEquals(2, playerState.getMilitaryStrength());

        playerState.setMilitaryTactic(Cards.FIGHTING_BAND);
        assertEquals(3, playerState.getMilitaryStrength());

        build(Cards.AIR_FORCES); // +5 from card, +1 from doubled tactics
        assertEquals(9, playerState.getMilitaryStrength());
    }

    @Test
    public void testCalculateHappiness() {
        assertEquals(0, playerState.getHappiness());

        instaBuild(Cards.KREMLIN);
        assertEquals(0, playerState.getHappiness()); // -1, can't get below 0

        playerState.build(Cards.RELIGION);
        assertEquals(0, playerState.getHappiness()); // +1 negates -1 from Kremlin

        instaBuild(Cards.ST_PETERS_BASILICA);
        assertEquals(2, playerState.getHappiness()); // +1 from Basilica itself and +1 additional from Religion
    }

    @Test
    public void testFormArmies() {

        tactic(Cards.FIGHTING_BAND)
                .add(Cards.WARRIORS)
                .test(0, 0);

        tactic(Cards.FIGHTING_BAND)
                .add(Cards.WARRIORS, 2)
                .test(1, 0);

        tactic(Cards.FIGHTING_BAND)
                .add(Cards.WARRIORS, 3)
                .test(1, 0);

        tactic(Cards.FIGHTING_BAND)
                .add(Cards.WARRIORS, 4)
                .test(2, 0);

        tactic(Cards.ENTRENCHMENTS)
                .add(Cards.RIFLEMEN)
                .add(Cards.CANNON, 2)
                .test(1, 0);

        tactic(Cards.ENTRENCHMENTS)
                .add(Cards.SWORDSMEN)
                .add(Cards.CANNON, 2)
                .test(0, 1);

        tactic(Cards.ENTRENCHMENTS)
                .add(Cards.RIFLEMEN, 2)
                .add(Cards.CANNON, 3)
                .test(1, 0);

        tactic(Cards.SHOCK_TROOPS)
                .add(Cards.SWORDSMEN, 1)
                .add(Cards.TANKS, 3)
                .test(0, 1);

        tactic(Cards.SHOCK_TROOPS)
                .add(Cards.MODERN_INFANTRY, 1)
                .add(Cards.TANKS, 3)
                .test(1, 0);

        tactic(Cards.SHOCK_TROOPS)
                .add(Cards.MODERN_INFANTRY, 2)
                .add(Cards.TANKS, 5)
                .test(1, 0);

        tactic(Cards.SHOCK_TROOPS)
                .add(Cards.MODERN_INFANTRY, 2)
                .add(Cards.TANKS, 5)
                .add(Cards.KNIGHTS)
                .test(1, 1);

        tactic(Cards.CLASSIC_ARMY)
                .add(Cards.RIFLEMEN, 7)
                .add(Cards.CAVALRYMEN, 15)
                .add(Cards.WARRIORS, 7)
                .test(3, 4);

    }

    @Test
    public void testFormArmiesGenghis() {

        tactic(Cards.NAPOLEONIC_ARMY)
                .add(Cards.RIFLEMEN, 2)
                .add(Cards.CANNON)
                .test(0, 0);

        playerState.electLeader(Cards.GENGHIS_KHAN);

        tactic(Cards.NAPOLEONIC_ARMY)
                .add(Cards.RIFLEMEN, 2)
                .add(Cards.CANNON)
                .test(1, 0);

        tactic(Cards.NAPOLEONIC_ARMY)
                .add(Cards.RIFLEMEN, 3)
                .add(Cards.CANNON, 2)
                .test(1, 0);

        tactic(Cards.NAPOLEONIC_ARMY)
                .add(Cards.RIFLEMEN, 3)
                .add(Cards.CANNON, 2)
                .add(Cards.WARRIORS)
                .test(1, 1);

    }

    @Test
    public void testGenghis3Culture() {
        playerState.electLeader(Cards.GENGHIS_KHAN);
        playerState.endTurn();
        assertEquals(3, playerState.getCulturePoints());
    }

    @Test
    public void testHasTheaters() {

        assertFalse(playerState.hasTheaters());
        assertEquals(11, Cards.MULTIMEDIA.getBuildingCost(playerState));
        assertEquals(6, Cards.JOURNALISM.getResearchCost(playerState));

        build(Cards.OPERA);

        assertTrue(playerState.hasTheaters());
        assertEquals(11, Cards.MULTIMEDIA.getBuildingCost(playerState));
        assertEquals(6, Cards.JOURNALISM.getResearchCost(playerState));

        playerState.electLeader(Cards.WILLIAM_SHAKESPEARE);

        assertEquals(10, Cards.MULTIMEDIA.getBuildingCost(playerState));
        assertEquals(5, Cards.JOURNALISM.getResearchCost(playerState));
    }

    @Test
    public void testHasLibraries() {
        assertFalse(playerState.hasLibraries());
        assertEquals(7, Cards.OPERA.getResearchCost(playerState));
        assertEquals(11, Cards.MOVIES.getBuildingCost(playerState));

        build(Cards.PRINTING_PRESS);

        assertTrue(playerState.hasLibraries());
        assertEquals(7, Cards.OPERA.getResearchCost(playerState));
        assertEquals(11, Cards.MOVIES.getBuildingCost(playerState));

        playerState.electLeader(Cards.WILLIAM_SHAKESPEARE);
        assertEquals(6, Cards.OPERA.getResearchCost(playerState));
        assertEquals(10, Cards.MOVIES.getBuildingCost(playerState));

    }

    @Test
    public void testShakespeareCultureProductionBonus() {

        build(Cards.PRINTING_PRESS); // +1
        build(Cards.JOURNALISM);     // +2
        assertEquals(3, playerState.getCultureProduction());

        build(Cards.DRAMA);          // +2
        build(Cards.OPERA);          // +3
        build(Cards.MOVIES);         // +4
        assertEquals(12, playerState.getCultureProduction());

        playerState.electLeader(Cards.WILLIAM_SHAKESPEARE);
        assertEquals(16, playerState.getCultureProduction()); // + 2 * 2 Library-Theater pairs

    }

    @Test
    public void testCharlieChaplinCultureProductionBonus() {

        assertEquals(0, playerState.getCultureProduction());

        build(Cards.DRAMA);
        assertEquals(2, playerState.getCultureProduction());

        build(Cards.OPERA); // +3
        assertEquals(5, playerState.getCultureProduction());

        playerState.electLeader(Cards.CHARLIE_CHAPLIN); // +3
        assertEquals(8, playerState.getCultureProduction());

        build(Cards.MOVIES); // +4, +1 (3->4)
        assertEquals(13, playerState.getCultureProduction());

        build(Cards.MOVIES); // +4
        assertEquals(17, playerState.getCultureProduction());

    }

    // Discover (if needed) and build
    private void build(BuildingCard buildingCard) {
        playerState.debugBuild(buildingCard);
    }

    @Test
    public void testJamesCookColonyCultureProductionBonus() {

        playerState.colonize(Cards.DEVELOPED_TERRITORY_I);

        assertEquals(0, playerState.getCultureProduction());

        playerState.electLeader(Cards.JAMES_COOK);
        assertEquals(2, playerState.getCultureProduction());

        playerState.colonize(Cards.DEVELOPED_TERRITORY_II);
        assertEquals(3, playerState.getCultureProduction());

    }

    @Test
    public void testNapoleonMilitaryBonus() {

        playerState.electLeader(Cards.NAPOLEON_BONAPARTE);

        assertEquals(3, playerState.getMilitaryStrength()); // 1 for Warriors, +2 for Infantry type

        build(Cards.SWORDSMEN);

        assertEquals(5, playerState.getMilitaryStrength()); // +2 for Swordsmen, +0 for Infantry type

        build(Cards.KNIGHTS);

        assertEquals(9, playerState.getMilitaryStrength()); // +2 for Knights, +2 for Cavalry type

        build(Cards.CAVALRYMEN);

        assertEquals(12, playerState.getMilitaryStrength()); // +3 for Cavalrymen, +0 for Cavalry type

        build(Cards.CANNON);

        assertEquals(17, playerState.getMilitaryStrength()); // +3 for Cannon, +2 for Artillery type

        build(Cards.ROCKETS);

        assertEquals(22, playerState.getMilitaryStrength()); // +5 for Rockets, +0 for Artillery type

        build(Cards.AIR_FORCES);

        assertEquals(29, playerState.getMilitaryStrength()); // +5 for Air Forces, +2 for Air Forces type

    }

    @Test
    public void testAvailableUpgrades() {

        checkUpgrades();

        playerState.discover(Cards.RIFLEMEN);
        checkUpgrades(upg(Cards.WARRIORS, Cards.RIFLEMEN));

        playerState.build(Cards.WARRIORS); // Nothing changes
        checkUpgrades(upg(Cards.WARRIORS, Cards.RIFLEMEN));

        playerState.build(Cards.RIFLEMEN); // Nothing changes
        checkUpgrades(upg(Cards.WARRIORS, Cards.RIFLEMEN));

        playerState.discover(Cards.MODERN_INFANTRY);
        checkUpgrades(upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY), upg(Cards.WARRIORS, Cards.RIFLEMEN), upg(Cards.WARRIORS, Cards.MODERN_INFANTRY));

        playerState.disband(Cards.WARRIORS);
        checkUpgrades(upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY), upg(Cards.WARRIORS, Cards.RIFLEMEN), upg(Cards.WARRIORS, Cards.MODERN_INFANTRY));

        playerState.disband(Cards.WARRIORS);
        checkUpgrades(upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY));

        playerState.discover(Cards.SWORDSMEN);
        checkUpgrades(upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY));

        playerState.build(Cards.SWORDSMEN);
        checkUpgrades(upg(Cards.SWORDSMEN, Cards.RIFLEMEN), upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY), upg(Cards.SWORDSMEN, Cards.MODERN_INFANTRY));

        playerState.build(Cards.WARRIORS);
        checkUpgrades(
                upg(Cards.WARRIORS, Cards.SWORDSMEN),
                upg(Cards.SWORDSMEN, Cards.RIFLEMEN),
                upg(Cards.RIFLEMEN, Cards.MODERN_INFANTRY),
                upg(Cards.WARRIORS, Cards.RIFLEMEN),
                upg(Cards.SWORDSMEN, Cards.MODERN_INFANTRY),
                upg(Cards.WARRIORS, Cards.MODERN_INFANTRY)
        );

    }

    @Test
    public void testSidMeier() {

        build(Cards.SCIENTIFIC_METHOD);
        build(Cards.SCIENTIFIC_METHOD);
        build(Cards.COMPUTERS);
        build(Cards.MULTIMEDIA);

        assertEquals(15, playerState.getScienceProduction());
        assertEquals(3, playerState.getCultureProduction());

        playerState.electLeader(Cards.SID_MEIER);

        assertEquals(11, playerState.getScienceProduction());
        assertEquals(10, playerState.getCultureProduction());

    }

    @Test
    public void testBillGates() {

        assertEquals(2, playerState.getResourceProduction());
        assertEquals(1, playerState.getScienceProduction());

        build(Cards.IRON); // +2
        build(Cards.IRON); // +2
        build(Cards.COAL); // +3

        build(Cards.SCIENTIFIC_METHOD); // +3
        build(Cards.SCIENTIFIC_METHOD); // +3
        build(Cards.COMPUTERS);         // +5

        assertEquals(9, playerState.getResourceProduction());
        assertEquals(12, playerState.getScienceProduction());

        playerState.electLeader(Cards.BILL_GATES);

        assertEquals(16, playerState.getResourceProduction());
        assertEquals(12, playerState.getScienceProduction());

        assertEquals(0, playerState.getCulturePoints());

        playerState.removeCurrentLeader();

        assertEquals(7, playerState.getCulturePoints());

    }

    private UpgradeDescription upg(UnitCard from, UnitCard to) {
        return UpgradeDescriptionFactory.get(from, to);
    }

    private void checkUpgrades(UpgradeDescription... upgradeDescriptions) {

        Collection<UpgradeDescription> availableUpgrades = playerState.getAvailableUpgrades();
        assertArrayEquals(availableUpgrades.toArray(), upgradeDescriptions);

    }

    private void instaBuild(WonderCard wonderCard) {
        playerState.addCardToHand(wonderCard);
        playerState.buildWonderStages(wonderCard.getStages().length);
    }

    private FormArmiesTestBuilder tactic(TacticCard tactic) {
        playerState.debugClearUnits();
        playerState.setMilitaryTactic(tactic);
        return new FormArmiesTestBuilder(playerState);
    }

    static class FormArmiesTestBuilder {

        private PlayerState playerState;

        public FormArmiesTestBuilder(PlayerState playerState) {
            this.playerState = playerState;
        }

        public FormArmiesTestBuilder add(UnitCard unit)
        {
            return add(unit, 1);
        }

        public FormArmiesTestBuilder add(UnitCard unit, int qty)
        {
            for (int i = 1; i <= qty; i++) {
                if (!playerState.hasDiscovered(unit))
                    playerState.discover(unit);
                playerState.build(unit);
            }
            return this;
        }

        public void test(int modernArmies, int obsoleteArmies) {
            playerState.formArmies();
            assertEquals(modernArmies, playerState.getModernArmies());
            assertEquals(obsoleteArmies, playerState.getObsoleteArmies());
        }

    }

}