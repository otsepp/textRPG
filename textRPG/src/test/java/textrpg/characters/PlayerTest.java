
package textrpg.characters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    private Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.player = new Player("Player");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void takeDamageWorks() {
        this.player.takeDamage(50);
        assertEquals(true, this.player.getHealth() == 100);
    }
 
}
