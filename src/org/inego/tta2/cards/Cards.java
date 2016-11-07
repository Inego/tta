package org.inego.tta2.cards;

import org.inego.tta2.cards.civil.BuildingCard;
import org.inego.tta2.cards.civil.ITechnologyCard;
import org.inego.tta2.cards.civil.action.*;
import org.inego.tta2.cards.civil.agriculture.*;
import org.inego.tta2.cards.civil.arena.ArenaCard;
import org.inego.tta2.cards.civil.arena.BreadNCircusesCard;
import org.inego.tta2.cards.civil.arena.ProSportsCard;
import org.inego.tta2.cards.civil.arena.TeamSportsCard;
import org.inego.tta2.cards.civil.government.DespotismCard;
import org.inego.tta2.cards.civil.government.GovernmentCard;
import org.inego.tta2.cards.civil.lab.*;
import org.inego.tta2.cards.civil.leader.*;
import org.inego.tta2.cards.civil.library.JournalismCard;
import org.inego.tta2.cards.civil.library.LibraryCard;
import org.inego.tta2.cards.civil.library.MultimediaCard;
import org.inego.tta2.cards.civil.library.PrintingPressCard;
import org.inego.tta2.cards.civil.mine.*;
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
import org.inego.tta2.cards.military.colony.*;
import org.inego.tta2.cards.military.tactic.*;

/**
 *
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
    public static final WonderCard KREMLIN = new KremlinCard();

    public static final FarmCard AGRICULTURE = new AgricultureCard();
    public static final FarmCard IRRIGATION = new IrrigationCard();
    public static final FarmCard SELECTIVE_BREEDING = new SelectiveBreedingCard();
    public static final FarmCard MECHANIZED_AGRICULTURE = new MechanizedAgricultureCard();

    public static final MineCard BRONZE = new BronzeCard();
    public static final MineCard IRON = new IronCard();
    public static final MineCard COAL = new CoalCard();
    public static final MineCard OIL = new OilCard();

    public static final LabCard PHILOSOPHY = new PhilosophyCard();
    public static final LabCard ALCHEMY = new AlchemyCard();
    public static final LabCard SCIENTIFIC_METHOD = new ScientificMethodCard();
    public static final LabCard COMPUTERS = new ComputersCard();

    public static final TempleCard RELIGION = new ReligionCard();
    public static final TempleCard THEOLOGY = new TheologyCard();
    public static final TempleCard ORGANIZED_RELIGION = new OrganizedReligionCard();

    public static final ArenaCard BREAD_N_CIRCUSES = new BreadNCircusesCard();
    public static final ArenaCard TEAM_SPORTS = new TeamSportsCard();
    public static final ArenaCard PRO_SPORTS = new ProSportsCard();

    public static final TheaterCard DRAMA = new DramaCard();
    public static final TheaterCard OPERA = new OperaCard();
    public static final TheaterCard MOVIES = new MoviesCard();

    public static final LibraryCard PRINTING_PRESS = new PrintingPressCard();
    public static final LibraryCard JOURNALISM = new JournalismCard();
    public static final LibraryCard MULTIMEDIA = new MultimediaCard();

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
    public static final LeaderCard LEONARDO_DA_VINCI = new LeonardoDaVinciCard();
    public static final LeaderCard JOAN_OF_ARC = new JoanOfArcCard();
    public static final LeaderCard CHRISTOPHER_COLUMBUS = new ChristopherColumbusCard();
    public static final LeaderCard FREDERICK_BARBAROSSA = new FrederickBarbarossaCard();
    public static final LeaderCard WILLIAM_SHAKESPEARE = new WilliamShakespeareCard();
    public static final LeaderCard JAMES_COOK = new JamesCookCard();
    public static final LeaderCard NAPOLEON_BONAPARTE = new NapoleonBonaparteCard();
    public static final LeaderCard MAXIMILIEN_ROBESPIERRE = new MaximilienRobespierreCard();
    public static final LeaderCard JS_BACH = new JsBachCard();
    public static final LeaderCard ISAAC_NEWTON = new IsaacNewtonCard();
    public static final LeaderCard ALBERT_EINSTEIN = new AlbertEinsteinCard();
    public static final LeaderCard CHARLIE_CHAPLIN = new CharlieChaplinCard();
    public static final LeaderCard MAHATMA_GANDHI = new MahatmaGandhiCard();
    public static final LeaderCard SID_MEIER = new SidMeierCard();
    public static final LeaderCard BILL_GATES = new BillGatesCard();
    public static final LeaderCard WINSTON_CHURCHILL = new WinstonChurchillCard();

    public static final TacticCard FIGHTING_BAND = new FightingBandCard();
    public static final TacticCard ENTRENCHMENTS = new EntrenchmentsCard();
    public static final TacticCard SHOCK_TROOPS = new ShockTroopsCard();
    public static final TacticCard CLASSIC_ARMY = new ClassicArmyCard();
    public static final TacticCard NAPOLEONIC_ARMY = new NapoleonicArmyCard();

    public static final ColonyCard DEVELOPED_TERRITORY_I = new DevelopedTerritory1Card();
    public static final ColonyCard DEVELOPED_TERRITORY_II = new DevelopedTerritory2Card();
    public static final ColonyCard HISTORIC_TERRITORY_I = new HistoricTerritory1Card();
    public static final ColonyCard HISTORIC_TERRITORY_II = new HistoricTerritory2Card();
    public static final ColonyCard INHABITED_TERRITORY_I = new InhabitedTerritory1Card();
    public static final ColonyCard INHABITED_TERRITORY_II = new InhabitedTerritory2Card();
    public static final ColonyCard STRATEGIC_TERRITORY_I = new StrategicTerritory1Card();
    public static final ColonyCard STRATEGIC_TERRITORY_II = new StrategicTerritory2Card();
    public static final ColonyCard VAST_TERRITORY_I = new VastTerritory1Card();
    public static final ColonyCard VAST_TERRITORY_II = new VastTerritory2Card();
    public static final ColonyCard WEALTHY_TERRITORY_I = new WealthyTerritory1Card();
    public static final ColonyCard WEALTHY_TERRITORY_II = new WealthyTerritory2Card();

    public static final ActionCard CULTURAL_HERITAGE_A = new CulturalHeritageACard();
    public static final ActionCard CULTURAL_HERITAGE_1 = new CulturalHeritage1Card();
    public static final ActionCard ENDOWMENT_FOR_ARTS = new EndowmentForArtsCard();
    public static final ActionCard MILITARY_BUILD_UP = new MilitaryBuildUpCard();
    public static final ActionCard WAVE_OF_NATIONALISM = new WaveOfNationalismCard();

}
