
package textrpg.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon equippedWeapon;
    private List<Usable> usableItems;
    
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        this.usableItems = new ArrayList();
        this.usableItems.add(new HealthPotion());
    }
    
    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    public List<Usable> getItems() {
        return this.usableItems;
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
}
