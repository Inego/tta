package org.inego.tta2.cards.civil.action;

import org.inego.tta2.gamestate.PlayerState;

/**
 * Created by Inego on 12.11.2016.
 */
public abstract class PatriotismCard extends SimpleActionCard {

    @Override
    public String getName() {
        return nameWithAge("Patriotism");
    }

    @Override
    public int getQty(int numberOfPlayers) {
        return 1;
    }

    @Override
    protected void performAction(PlayerState playerState) {
        playerState.gainMilitaryActions(1);
        playerState.gainMilitaryProductionBonus(getAge() + 1);
    }

    public static final PatriotismCard AGE_A = new PatriotismCard() {
        @Override
        public int getAge() {
            return 0;
        }
    };
    public static final PatriotismCard AGE_1 = new PatriotismCard() {
        @Override
        public int getAge() {
            return 1;
        }
    };
    public static final PatriotismCard AGE_2 = new PatriotismCard() {
        @Override
        public int getAge() {
            return 2;
        }
    };
    public static final PatriotismCard AGE_3 = new PatriotismCard() {
        @Override
        public int getAge() {
            return 3;
        }
    };

}
