package org.inego.tta2.cards.military;

import org.inego.tta2.cards.Cards;
import org.inego.tta2.gamestate.PlayerState;

/**
 * The common ancestor of Wars and Aggressions.
 */
public abstract class AttackingCard extends MilitaryCard {

    /**
     * Returns the military action cost of attacking a given player.
     *
     * @param attacker The attacker's player state
     * @param target The target player state
     * @return Military action cost of attack
     */
    public int getAttackingCost(PlayerState attacker, PlayerState target) {
        return getBaseAttackingCost() * (target.getLeader() == Cards.MAHATMA_GANDHI ? 2 : 1);
    }

    /**
     * Returns the base Military Action cost of activating the attack.
     *
     * @return Base attacking cost, in MA points
     */
    public abstract int getBaseAttackingCost();

    /**
     * Checks whether this card can be used for attacking.
     *
     * @param attacker Attacker
     * @param target Target of attack
     * @return {@code true} if the attack is possible
     */
    public boolean canAttack(PlayerState attacker, PlayerState target) {
        if (attacker.getLeader() == Cards.MAHATMA_GANDHI)
            return false;
        return true;
    }

}
