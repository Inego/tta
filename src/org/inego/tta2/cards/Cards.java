package org.inego.tta2.cards;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.government.DespotismCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.leader.*;
import org.inego.tta2.cards.civil.temple.OrganizedReligionCard;
import org.inego.tta2.cards.civil.temple.ReligionCard;
import org.inego.tta2.cards.civil.temple.TempleCard;
import org.inego.tta2.cards.civil.temple.TheologyCard;
import org.inego.tta2.cards.civil.theater.DramaCard;
import org.inego.tta2.cards.civil.theater.MoviesCard;
import org.inego.tta2.cards.civil.theater.OperaCard;
import org.inego.tta2.cards.civil.theater.TheaterCard;
import org.inego.tta2.cards.civil.unit.*;
import org.inego.tta2.cards.civil.wonder.*;
import org.inego.tta2.cards.military.tactic.FightingBandCard;
import org.inego.tta2.cards.military.tactic.TacticCard;

/**
 * Created by Inego on 21.08.2016.
 */
public class Cards {

    public static final GovernmentCard DESPOTISM = new DespotismCard();

    public static final WonderCard GREAT_WALL = new GreatWallCard();
    public static final WonderCard LIBRARY_OF_ALEXANDRIA = new LibraryOfAlexandriaCard();
    public static final WonderCard ST_PETERS_BASILICA = new StPetersBasilicaCard();
    public static final WonderCard UNIVERSITAS_CAROLINA = new UniversitasCarolinaCard();
    public static final WonderCard TAJ_MAHAL = new TajMahalCard();
    public static final WonderCard HOLLYWOOD = new HollywoodCard();
    public static final WonderCard TRANSCONTINENTAL_RR = new TranscontinentalRailroadCard();
    public static final WonderCard INTERNET = new InternetCard();
    public static final WonderCard FIRST_SPACE_FLIGHT = new FirstSpaceFlightCard();
    public static final WonderCard FAST_FOOD_CHAINS = new FastFoodChainsCard();

    public static final TempleCard RELIGION = new ReligionCard();
    public static final TempleCard THEOLOGY = new TheologyCard();
    public static final TempleCard ORGANIZED_RELIGION = new OrganizedReligionCard();

    public static final TheaterCard DRAMA = new DramaCard();
    public static final TheaterCard OPERA = new OperaCard();
    public static final TheaterCard MOVIES = new MoviesCard();

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

    public static final LeaderCard JULIUS_CAESAR = new JuliusCaesarCard();
    public static final LeaderCard HOMER = new HomerCard();
    public static final LeaderCard MOSES = new MosesCard();
    public static final LeaderCard HAMMURABI = new HammurabiCard();
    public static final LeaderCard ARISTOTLE = new AristotleCard();
    public static final LeaderCard ALEXANDER = new AlexanderCard();
    public static final LeaderCard MICHELANGELO = new MichelangeloCard();
    public static final LeaderCard GENGHIS_KHAN = new GenghisKhanCrd();

    public static final LeaderCard JOAN_OF_ARC = new JoanOfArcCard();
    public static final TacticCard FIGHTING_BAND = new FightingBandCard();
}
