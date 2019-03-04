/*
 * Testing the Set Class
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
public class SetTest {
    
    public SetTest() {
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
     * Test of addSetScoresAndPlayers method, of class Set.
     * testing to ensure that value are set properly
     */
    @Test
    public void testAddSetScores() {
        System.out.println("addSetScoresAndPlayers");
        int game0h = 10;
        int game0a = 10;
        int game1h = 10;
        int game1a = 10;
        int game2h = 10;
        int game2a = 10;
        Set instance = new Set();
        instance.addSetScoresAndPlayers(game0h, game0a, game1h, game1a, game2h, game2a);
        assertEquals(game0h, 10);
        assertEquals(game0a, 10);
        assertEquals(game1h, 10);
        assertEquals(game1a, 10);
        assertEquals(game2h, 10);
        assertEquals(game2a, 10);
    }

    /**
     * Test of calculateSetScores method, of class Set.
     * testing to ensure that the method is counting properly
     */
    @Test
    public void testCalculateSetScores() {
        System.out.println("calculateSetScores");
        Set set = new Set();
        set.addSetScoresAndPlayers(10, 9, 8, 7, 6, 5);
        set.calculateSetScores();
        assertEquals(set.getGames().get(0).getHomeScore(), 10);
        assertEquals(set.getGames().get(0).getAwayScore(), 9);
        assertEquals(set.getGames().get(1).getHomeScore(), 8);
        assertEquals(set.getGames().get(1).getAwayScore(), 7);
        assertEquals(set.getGames().get(2).getHomeScore(), 6);
        assertEquals(set.getGames().get(2).getAwayScore(), 5);
    }

    
    
}
