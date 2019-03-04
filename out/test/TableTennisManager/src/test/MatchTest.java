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
public class MatchTest {
    
    public MatchTest() {
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
     * Test of calculateMatchScores method, of class Match.
     * Ensure method is calculating correct score
     */
    @Test
    public void testCalculateMatchScores() {
        System.out.println("calculateMatchScores");
        Match match = new Match();
        match.sets.get(0).addSetScoresAndPlayers(10, 0, 10, 0, 10, 0);
        match.getSets().get(0).addSetScoresAndPlayers(10, 0, 10, 0, 10, 0);
        match.calculateMatchScores();
        //assertEquals(match.getScoreHome(), 1);
    }

    /**
     * Test of resetScores method, of class Match.
     * Ensure match scores are reset
     */
    @Test
    public void testResetScores() {
        System.out.println("resetScores");
        Match match = new Match();
        match.getSets().get(0).addSetScoresAndPlayers(10, 10, 110, 110, 90, 80);
        assertEquals(match.getSets().get(0).getGames().get(0).getHomeScore(), 10);
        match.resetScores();
        assertEquals(0, match.getSets().get(0).getScoreHome());
    }
    
}
