package org.inego.tta2.gamestate.comparison;

import org.inego.tta2.gamestate.PlayerState;

import java.util.Comparator;

public class PlayerComparison {

    /**
     * Sorts players in ascending by number of waiting turns, i. e. the sooner to play players will be first
     */
    public static final Comparator<PlayerState> PLAYING_ORDER = (o1, o2) -> o1.getWaitingTurns() - o2.getWaitingTurns();

    /**
     * Sorts players in descending their military strength, i. e. the stronger players will be first
     */
    public static final Comparator<PlayerState> MILITARY_STRENGTH = new Comparator<PlayerState>() {
        @Override
        public int compare(PlayerState o1, PlayerState o2) {
            return o2.getMilitaryStrength() - o1.getMilitaryStrength();
        }
    }.thenComparing(PLAYING_ORDER);

}
