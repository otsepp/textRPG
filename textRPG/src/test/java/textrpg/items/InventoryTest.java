
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
        assertEquals(true, this.inventory.getUsableItems() != null);
        assertEquals(true, this.inventory.getEquippedWeapon() != null);
        assertEquals(true, this.inventory.getUsableItems().size() > 0);
    }
    
    @Test
    public void addingUsableItemsWorks() {
        Map<Usable, Integer> usables = this.inventory.getUsableItems();
        
        HealthPotion potion = new HealthPotion(this.inventory);
        this.inventory.addUsableItem(potion);
        
        assertEquals(1, usables.size());
        assertEquals(true, usables.get(potion) == 3);
    }
    
    @Test
    public void removingUsableItemsWorks() {
        Map<Usable, Integer> usables = this.inventory.getUsableItems();
        HealthPotion potion = new HealthPotion(this.inventory);
        
        this.inventory.addUsableItem(potion);
        this.inventory.removeUsableItem(potion);
        
        assertEquals(1, usables.size());
        assertEquals(true, usables.get(potion) == 2);
        
        this.inventory.removeUsableItem(potion);
        this.inventory.removeUsableItem(potion);
        assertEquals(false, usables.containsKey(potion));
        assertEquals(0, usables.size());
    }
    
    
    
}
