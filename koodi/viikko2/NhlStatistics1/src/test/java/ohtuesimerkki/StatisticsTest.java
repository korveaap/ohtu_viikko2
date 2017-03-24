/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aapo
 */
public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    public StatisticsTest() {
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test    
    public void pelaajaLoytyy() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }
    
    @Test
    public void pelaajaaEiLoydy() {
        Player p = stats.search("Karri");
        assertEquals(null, p);
    }
    
    @Test
    public void haeJoukkue() {
        List<Player> joukkue = stats.team("EDM");
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void haeScooraajat() {
        List<Player> joukkue = stats.topScorers(1);
        assertEquals(2, joukkue.size());
    }

    
    
}
