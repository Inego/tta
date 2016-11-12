package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 12.11.2016.
 */
public abstract class RevolutionaryIdeaCard extends SimpleActionCard {

    @Override
    public String getName() {
        return nameWithAge("Revolutionary Idea");
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return getAge() == 4 ? 2 : 1;
    }

    @Override
    protected void performAction(PlayerState playerState) {
        playerState.gainSciencePoints(2 * getAge());
    }

    public static final RevolutionaryIdeaCard AGE_2 = new RevolutionaryIdeaCard() {
        @Override
        public int getAge() {
            return 2;
        }
    };

    public static final RevolutionaryIdeaCard AGE_3 = new RevolutionaryIdeaCard() {
        @Override
        public int getAge() {
            return 2;
        }
    };
}
