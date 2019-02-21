
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tabletennismanager.Match;
import tabletennismanager.Season;
import tabletennismanager.Team;

import static org.junit.Assert.*;

/**
 *
 * @author rg3-williams
 */
public class SeasonTest {

    public SeasonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addTeam method, of class Season.
     */
    @Test
    public void testAddTeam() {
        System.out.println("addTeam");
        Season season = new Season();
        Team team = new Team("team");
        season.addTeam(team);
        assertEquals(team, season.getTeams().get(0));
    }

    /**
     * Test of addMatch method, of class Season.
     */
    @Test
    public void testAddMatch() {
        System.out.println("addMatch");
        Season season = new Season();
        Match match = new Match(new Team("team1"),new Team("team2"));
        season.addMatch(match);
        assertEquals(match, season.getFixtures().get(0));
    }

    /**
     * Test of generateFixtures method, of class Season.
     */
    @Test
    public void testGenerateFixtures() {
        System.out.println("generateFixtures");
        Season instance = new Season();
        instance.addTestData();
        instance.generateFixtures();
        assertEquals(instance.getFixtures().get(11).getTeamHome()  , instance.getTeams().get(3));

    }

    /**
     * Test of generateStats method, of class Season.
     */
    @Test
    public void testGenerateStats() {
        System.out.println("generateStats");
        Season instance = new Season();
        instance.addTestData();
        instance.generateFixtures();
        instance.calculateScores();
        instance.generateStats();
        assertEquals(instance.getTeams().get(0).getGamesWon()  , 16);

    }

    /**
     * Test of displayTeamStats method, of class Season.
     */
    @Test
    public void testDisplayTeamStats() {
        System.out.println("displayTeamStats");
        Season instance = new Season();
        instance.displayTeamStats();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayLeaderBoard method, of class Season.
     */
    @Test
    public void testDisplayLeaderBoard() {
        System.out.println("displayLeaderBoard");
        Season instance = new Season();
        instance.displayLeaderBoard();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of displayAMatch method, of class Season.
     */
    @Test
    public void testDisplayAMatch() {

    }

    /**
     * Test of displayFixtures method, of class Season.
     */
    @Test
    public void testDisplayFixtures() {
        System.out.println("displayFixtures");
        Season instance = new Season();
        instance.displayFixtures();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of autoUpdateThread method, of class Season.
     */
    @Test
    public void testAutoUpdateThread() {
        System.out.println("autoUpdateThread");
        Season instance = new Season();
        instance.autoUpdateThread();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateScores method, of class Season.
     */
    @Test
    public void testCalculateScores() {
        System.out.println("calculateScores");
        Season instance = new Season();
        instance.addTestData();
        instance.generateFixtures();
        instance.calculateScores();
        assertEquals(instance.getFixtures().get(0).sets.get(0).games.get(0).getHomeScore()  , 11);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addTestData method, of class Season.
     */
    @Test
    public void testAddTestData() {
        System.out.println("addTestData");
        Season instance = new Season();
        instance.addTestData();
        // TODO review the generated test code and remove the default call to fail.
    }

}
