
package textrpg.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Weapon equippedWeapon;
    private Map<Usable, Integer> usableItems;
    
    
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        
        this.usableItems = new HashMap();
        addUsableItem(new HealthPotion(this));
        addUsableItem(new HealthPotion(this));
    }

    
    public void addUsableItem(Usable item) {
        if (!this.usableItems.containsKey(item)) {
            this.usableItems.put(item, 1);
        
        } else {
            this.usableItems.put(item, this.usableItems.get(item) + 1);
        }
    }
    
    public void removeUsableItem(Usable item) {
        int count = this.usableItems.get(item);
        
        if (count > 1) {
            this.usableItems.put(item, this.usableItems.get(item) - 1);
            
        } else if (count == 1) {
            this.usableItems.remove(item);
        } 
    }
    
    public void removeAllUsableItems() {
        this.usableItems.clear();
    }
    
    public Map<Usable, Integer> getUsableItems() {
        return this.usableItems;
    }
    
    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
}
