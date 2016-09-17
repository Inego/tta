package org.inego.tta2.gamestate;

import org.junit.Test;

import static org.inego.tta2.gamestate.tactics.Utils.getGenghisKhanMaxArmies;
import static org.junit.Assert.*;

/**
 * Created by Inego on 17.09.2016.
 */
public class UtilsTest {

    @Test
    public void testGetGenghisKhanMaxArmies() throws Exception {

        // Heavy cavalry
        assertEquals(0, getGenghisKhanMaxArmies(3, 0, 1, 1));
        assertEquals(1, getGenghisKhanMaxArmies(3, 0, 1, 2));
        assertEquals(1, getGenghisKhanMaxArmies(3, 0, 3, 2));
        assertEquals(2, getGenghisKhanMaxArmies(3, 0, 3, 3));

        // Phalanx
        assertEquals(0, getGenghisKhanMaxArmies(1, 2, 0, 2));
        assertEquals(1, getGenghisKhanMaxArmies(1, 2, 1, 2));
        assertEquals(1, getGenghisKhanMaxArmies(1, 2, 0, 3));
        assertEquals(33, getGenghisKhanMaxArmies(1, 2, 0, 100));

        // Conquistadors
        assertEquals(0, getGenghisKhanMaxArmies(2, 1, 0, 2));
        assertEquals(1, getGenghisKhanMaxArmies(2, 1, 1, 2));
        assertEquals(1, getGenghisKhanMaxArmies(2, 1, 0, 5));
        assertEquals(2, getGenghisKhanMaxArmies(2, 1, 0, 6));
        assertEquals(10, getGenghisKhanMaxArmies(2, 1, 1000, 10));
        assertEquals(336, getGenghisKhanMaxArmies(2, 1, 10, 1000));

    }

}