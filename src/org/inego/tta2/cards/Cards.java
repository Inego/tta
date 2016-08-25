package org.inego.tta2.cards;

import org.inego.tta2.cards.civil.*;
import org.inego.tta2.cards.civil.government.DespotismCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.unit.*;
import org.inego.tta2.cards.civil.wonder.GreatWallCard;
import org.inego.tta2.cards.civil.wonder.LibraryOfAlexandriaCard;
import org.inego.tta2.cards.civil.wonder.StPetersBasilicaCard;
import org.inego.tta2.cards.civil.wonder.WonderCard;

/**
 * Created by Inego on 21.08.2016.
 */
public class Cards {

    public static final GovernmentCard DESPOTISM = new DespotismCard();

    public static final WonderCard GREAT_WALL = new GreatWallCard();
    public static final WonderCard LIBRARY_OF_ALEXANDRIA = new LibraryOfAlexandriaCard();
    public static final WonderCard ST_PETERS_BASILICA = new StPetersBasilicaCard();

    public static final UnitCard WARRIORS = new WarriorsCard();

    public static final UnitCard SWORDSMEN = new SwordsmenCard();
    public static final UnitCard RIFLEMEN = new RiflemenCard();
    public static final UnitCard MODERN_INFANTRY = new ModernInfantryCard();
    public static final UnitCard KNIGHTS = new KnightsCard();
    public static final UnitCard CAVALRYMEN = new CavalrymenCard();
    public static final UnitCard TANKS = new TanksCard();
    public static final UnitCard CANNON = new CannonCard();
    public static final UnitCard ROCKETS = new RocketsCard();
    public static final UnitCard AIR_FORCES = new AirForcesCard();

}
