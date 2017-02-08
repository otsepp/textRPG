
package textrpg.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Weapon equippedWeapon;
    //make to hashmap
    private Map<Usable, Integer> usableItemsHash;
    
    private List<Usable> usableItems;
    
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        this.usableItems = new ArrayList();
        this.usableItems.add(new HealthPotion(this));
        
        this.usableItemsHash = new HashMap();
        addUsableItemHash(new HealthPotion(this));
    }
    
   
    
    public void addUsableItemHash(Usable item) {
        if (!this.usableItemsHash.containsKey(item)) {
            this.usableItemsHash.put(item, 1);
        
        } else {
            this.usableItemsHash.put(item, this.usableItemsHash.get(item) + 1);
        }
    }
    
    public void removeUsableItemHash(Usable item) {
        int count = this.usableItemsHash.get(item);
        
        if (count > 1) {
            this.usableItemsHash.put(item, this.usableItemsHash.get(item) - 1);
            
        } else if (count == 1) {
            this.usableItemsHash.remove(item);
        } 
    }

    public Map<Usable, Integer> getUsableItemsHash() {
        return this.usableItemsHash;
    }
    
    
     public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
    
    
     
    public List<Usable> getUsableItems() {
        return this.usableItems;
    }
    
    public void removeUsableItem(Usable item) {
        if (this.usableItems.contains(item)) {
            this.usableItems.remove(item);
        }
    }
    
}
