package org.inego.tta2.gamestate;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.cards.civil.unit.UnitCard;
import org.inego.tta2.cards.civil.wonder.WonderCard;
import org.inego.tta2.cards.military.tactic.TacticCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Inego on 16.09.2016.
 */
public class PlayerStateTest {

    private GameState gameState = new GameState(3);
    private PlayerState playerState;

    @Before
    public void setUp() {
        playerState = new PlayerState(gameState);
    }

    @Test
    public void testCalculateCultureProduction() {

        assertEquals(0, playerState.getCultureProduction());

        playerState.build(Cards.THEOLOGY);
        assertEquals(1, playerState.getCultureProduction());

        playerState.build(Cards.OPERA);
        assertEquals(4, playerState.getCultureProduction());

        playerState.build(Cards.OPERA);
        assertEquals(7, playerState.getCultureProduction());

        playerState.electLeader(Cards.MICHELANGELO);
        assertEquals(11, playerState.getCultureProduction());

    }

    @Test
    public void testCalculateMilitaryStrength() {
        assertEquals(1, playerState.getMilitaryStrength());

        playerState.build(Cards.WARRIORS);
        assertEquals(2, playerState.getMilitaryStrength());

        playerState.setMilitaryTactic(Cards.FIGHTING_BAND);
        assertEquals(3, playerState.getMilitaryStrength());
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


    }

    private void instaBuild(WonderCard wonderCard) {
        playerState.takeCard(wonderCard);
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
            for (int i = 1; i <= qty; i++)
                playerState.build(unit);
            return this;
        }

        public void test(int modernArmies, int obsoleteArmies) {
            playerState.formArmies();
            assertEquals(modernArmies, playerState.getModernArmies());
            assertEquals(obsoleteArmies, playerState.getObsoleteArmies());
        }

    }

}