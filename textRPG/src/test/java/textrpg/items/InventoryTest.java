
package textrpg.items;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {
    
    private Inventory inventory;
    
    public InventoryTest() {
    }
    
    @Before
    public void setUp() {
        this.inventory = new Inventory();
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(true, this.inventory.getUsableItemsHash() != null);
        assertEquals(true, this.inventory.getEquippedWeapon() != null);
        assertEquals(true, this.inventory.getUsableItemsHash().size() > 0);
    }
    
    @Test
    public void addingUsableItemsWorks() {
        Map<Usable, Integer> usables = this.inventory.getUsableItemsHash();
        
        HealthPotion potion = new HealthPotion(this.inventory);
        this.inventory.addUsableItemHash(potion);
        
        assertEquals(1, usables.size());
        assertEquals(true, usables.get(potion) == 2);
    }
    
    @Test
    public void removingUsableItemsWorks() {
        Map<Usable, Integer> usables = this.inventory.getUsableItemsHash();
        HealthPotion potion = new HealthPotion(this.inventory);
        
        this.inventory.addUsableItemHash(potion);
        this.inventory.removeUsableItemHash(potion);
        
        assertEquals(1, usables.size());
        assertEquals(true, usables.get(potion) == 1);
        
        this.inventory.removeUsableItemHash(potion);
        assertEquals(false, usables.containsKey(potion));
        assertEquals(0, usables.size());
    }
    
}
