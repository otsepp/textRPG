
package textrpg.characters;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.items.Weapon;

public class PlayerTest {
    
    private Player player;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        this.player = new Player("Player");
    }

    
    @Test
    public void takeDamageWorks() {
        this.player.takeDamage(50);
        assertEquals(100, this.player.getHealth());
    }
    
    @Test
    public void updateDamageWorks() {
        Weapon w = new Weapon("Longsword", 15);
        this.player.getInventory().setEquippedWeapon(w);
        this.player.updateDamage();
        assertEquals(25, this.player.getTotalDamage());
    }
 
}
