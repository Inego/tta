package org.inego.tta2.gamestate.tactics;

/**
 *
 */
public class Utils {

    /**
     * Computes the maximum available armies consisting of required number of cavalry and infantry
     * using Genghis Khan's special ability of considering infantry as cavalry if required.
     *
     * @param cavalry Number of cavalry units in the army, <strong>greater than 0</strong>
     * @param infantry Number of infantry units in the army
     * @param availableCavalry Available cavalry units
     * @param availableInfantry Available infantry units
     * @return Maximum number of armies
     */
    public static int getGenghisKhanMaxArmies(int cavalry, int infantry, int availableCavalry, int availableInfantry) {

        /*
        We must find the maximum i satisfying the following system of integer inequalities:
        aC + d >= i * X
        aI - d >= i * Y
        d >= 0
        i >= 0
        where aC and aI are available cavalry and infantry, d is the number of infantry units considered as cavalry,
        i is the number of armies, X and Y are cavalry and infantry composition of an army.

        This can be rewritten as finding the biggest i such that
        i <= (aC + aI) / (X + Y)
        i <= aI / Y  --- since Y may be 0, this applies only when Y > 0
        */

        int result = (availableCavalry + availableInfantry) / (cavalry + infantry);

        if (infantry > 0)
            result = Math.min(result, availableInfantry / infantry);

        return result;
    }

}
