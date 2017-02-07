
package textrpg.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon equippedWeapon;
    //make to hashmap
    private List<Usable> usableItems;
    
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        this.usableItems = new ArrayList();
        this.usableItems.add(new HealthPotion(this));
    }
    
    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    public List<Usable> getUsableItems() {
        return this.usableItems;
    }
    
    public void removeUsableItem(Usable item) {
        if (this.usableItems.contains(item)) {
            this.usableItems.remove(item);
        }
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
}
