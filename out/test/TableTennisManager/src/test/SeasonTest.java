/*
 * Testing the Season class
 */
package tabletennismanager;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d3-worgan
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
     * Ensure that correct team object is appended to the correct list
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
     * Ensure that the correct match object has been appended to the correct list
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
     * Ensure that that a pair of fixtures is generated for each team
     */
    @Test
    public void testGenerateFixtures() {
        System.out.println("generateFixtures");
        Season season = new Season();
        season.addTestData();
        season.generateFixtures();
        Team team1 = season.getTeams().get(0);
        Team team2 = season.getTeams().get(1);
        Team team3 = season.getTeams().get(2);
        Team team4 = season.getTeams().get(3);
        
        assertEquals(season.getFixtures().get(0).getTeamHome(),team1);
        assertEquals(season.getFixtures().get(0).getTeamAway(),team2);
        assertEquals(season.getFixtures().get(1).getTeamHome(),team1);
        assertEquals(season.getFixtures().get(1).getTeamAway(),team3);
        assertEquals(season.getFixtures().get(2).getTeamHome(),team1);
        assertEquals(season.getFixtures().get(2).getTeamAway(),team4);
    }

    /**
     * Test of generateStats method, of class Season.
     * Ensure that the method calculates and updates the correct data
     */
    @Test
    public void testGenerateStats() {
        System.out.println("generateStats");

        Season season = new Season();
        Team home = new Team("home");
        Team away = new Team("away");
        season.addTeam(home);
        season.addTeam(away);
        Match match = new Match(home, away);
        match.getSets().get(0).addSetScoresAndPlayers(11, 0, 11, 10, 10, 0);
        int game1Hs = match.getSets().get(0).getGames().get(0).getHomeScore();
        assertEquals(game1Hs, 11);
        season.addMatch(match);
        season.getFixtures().get(0).setMatchPlayed(true);
        System.out.println(season.getFixtures().get(0).getTeamHome().getTeamName());
        game1Hs = season.getFixtures().get(0).getSets().get(0).getGames().get(0).getHomeScore();
        assertEquals(game1Hs, 11);
        season.calculateScores();
        season.generateStats();

        System.out.println("Score home");
        System.out.println(season.fixtures.get(0).getScoreHome());
        System.out.println("Score away");
        System.out.println(season.fixtures.get(0).getScoreAway());
        // Check that the correct points have been added
        assertEquals(season.getFixtures().get(0).getScoreHome(), 1);
        assertEquals(season.getFixtures().get(0).getScoreAway(), 4);
        
        // Check the team has been updated
        assertEquals(season.getTeams().get(0).getMatchesPlayed(), 1);
        assertEquals(season.getTeams().get(1).getMatchesPlayed(), 1);
        assertEquals(season.getTeams().get(0).getMatchesWon(), 0);
        assertEquals(season.getTeams().get(1).getMatchesWon(), 1);
        assertEquals(season.getTeams().get(0).getSetsWon(), 1);
        assertEquals(season.getTeams().get(1).getSetsWon(), 4);
//             
    }

    /**
     * Test of calculateScores method, of class Season.
     */
    @Test
    public void testCalculateScores() {
        System.out.println("calculateScores");
        Season season = new Season();
        Match match = new Match();
        match.getSets().get(0).addSetScoresAndPlayers(11, 0, 11, 0, 11, 0);
        match.setMatchPlayed(true);
        season.addMatch(match);
        int game1Hs = match.getSets().get(0).getGames().get(0).getHomeScore();
        assertEquals(game1Hs, 11);
        season.calculateScores();
        game1Hs = match.getSets().get(0).getGames().get(0).getHomeScore();
        assertEquals(game1Hs, 11);
        System.out.println("fghs");
        System.out.println(season.getFixtures().get(0).getSets().get(0).getGames().get(0).getHomeScore());
        System.out.println("Match score away");
        System.out.println(season.getFixtures().get(0).getScoreAway());
        
        // testing match scores were calculated proper;y
        assertEquals(season.getFixtures().get(0).getScoreHome(), 1);
        assertEquals(season.getFixtures().get(0).getScoreAway(), 4);
        
    }

    
}
