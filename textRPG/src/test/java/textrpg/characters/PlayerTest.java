
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
    public void updateDamageWorks() {
        Weapon w = new Weapon("Longsword", 15);
        this.player.getInventory().setEquippedWeapon(w);
        this.player.updateDamage();
        assertEquals(25, this.player.getTotalDamage());
    }
    
    @Test
    public void takeDamageWorks() {
        int oldHealth = this.player.getHealth();
        this.player.takeDamage(50);
        assertEquals(oldHealth - 50, this.player.getHealth());
    }
    
    @Test
    public void isDeadWorks() {
        assertEquals(false, this.player.isDead());
        int health = this.player.getHealth();
        player.takeDamage(health);
        assertEquals(true, this.player.isDead());
    }
    
    @Test
    public void addHealthWorks() {
        int oldHealth = this.player.getHealth();
        this.player.addHealth(100);
        assertEquals(oldHealth, this.player.getHealth());
        
        this.player.takeDamage(50);
        this.player.addHealth(25);
        assertEquals(oldHealth - 25, this.player.getHealth());
    }
 
}
