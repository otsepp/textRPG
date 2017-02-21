
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
        usables.clear();
        
        HealthPotion potion = new HealthPotion(this.inventory);
        this.inventory.addUsableItem(potion);
        this.inventory.addUsableItem(potion);
         assertEquals(1, usables.size());
         int itemCount = usables.get(potion);
         assertEquals(2, itemCount);
         
         Bomb bomb = new Bomb(this.inventory);
        this.inventory.addUsableItem(bomb);
        assertEquals(2, usables.size());
        itemCount = usables.get(bomb);
        assertEquals(1, itemCount);
    }
    
//    @Test
    public void removingUsableItemsWorks() {
        Map<Usable, Integer> usables = this.inventory.getUsableItems();
        this.inventory.removeAllUsableItems();
        assertEquals(0, usables.size());
        
        //adding some filler
        HealthPotion potion = new HealthPotion(this.inventory);
        this.inventory.addUsableItem(potion);
        this.inventory.addUsableItem(potion);
        Bomb bomb = new Bomb(this.inventory);
        this.inventory.addUsableItem(bomb);
        
        this.inventory.removeUsableItem(bomb);
        assertEquals(1, usables.size());
        
        this.inventory.removeUsableItem(potion);
        assertEquals(1, usables.size());
        int itemCount = usables.get(potion);
        assertEquals(1, itemCount);
    }
    
    
    
}
