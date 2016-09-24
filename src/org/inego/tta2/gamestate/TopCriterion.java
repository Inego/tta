package org.inego.tta2.gamestate;

public interface TopCriterion {

    TopCriterion STRENGTH = PlayerState::getMilitaryStrength;

    int getValue(PlayerState playerState);

}
