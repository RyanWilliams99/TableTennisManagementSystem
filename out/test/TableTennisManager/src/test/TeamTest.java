/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class TeamTest {
    
    public TeamTest() {
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
     * Test of addPlayer method, of class Team.
     * Ensure player is added to team
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = new Player("New Player");
        Team team = new Team();
        team.addPlayer(player);
        assertEquals(player, team.getPlayers().get(0));
    }

    /**
     * Test of setLostValues method, of class Team.
     * Unused Function?
     */
    @Test
    public void testSetLostValues() {
        System.out.println("setLostValues");
    }

    /**
     * Test of resetStats method, of class Team.
     * Ensure function resets team stats
     */
    @Test
    public void testResetStats() {
        System.out.println("resetStats");
        Team team = new Team();
        team.setGamesPlayed(10);
        team.setGamesWon(10);
        team.setSetsPlayed(10);
        assertEquals(team.getGamesPlayed(), 10);
        assertEquals(team.getGamesWon(), 10);
        assertEquals(team.getSetsPlayed(), 10);
        assertEquals(team.getGamesPlayed(), 10);
        team.resetStats();
        assertEquals(team.getGamesPlayed(), 0);
        assertEquals(team.getGamesWon(), 0);
        assertEquals(team.getSetsPlayed(), 0);
        assertEquals(team.getGamesPlayed(), 0);
    }

    
}
