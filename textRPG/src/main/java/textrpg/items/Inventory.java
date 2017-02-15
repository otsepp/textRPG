
package textrpg.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reppua kuvaava luokka. Sisältää käytettävissä olevan aseen ja kokoelman käytettäviä tavaroita.
 */
public class Inventory {
    private Weapon equippedWeapon;
    private Map<Usable, Integer> usableItems;
    
    /**
     * Luo uuden olion. Luo oletuksen aseen ja kaksi elämäjuomaa.
     */
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        
        this.usableItems = new HashMap();
        addUsableItem(new HealthPotion(this));
        addUsableItem(new HealthPotion(this));
    }

    /**
     * Lisää reppuun käytettävän tavaran.
     * @param item Lisättävä tavara
     */
    public void addUsableItem(Usable item) {
        if (!this.usableItems.containsKey(item)) {
            this.usableItems.put(item, 1);
        
        } else {
            this.usableItems.put(item, this.usableItems.get(item) + 1);
        }
    }
    
    /**
     * Poistaa repusta käytettävän tavaran.
     * @param item Poistettava tavara.
     */
    public void removeUsableItem(Usable item) {
        int count = this.usableItems.get(item);
        
        if (count > 1) {
            this.usableItems.put(item, this.usableItems.get(item) - 1);
            
        } else if (count == 1) {
            this.usableItems.remove(item);
        } 
    }
    
    /**
     * Tyhjentää käytettävien tavaroiden kokoelman.
     */
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
