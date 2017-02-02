
package textrpg.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon equippedWeapon;
    private List<Item> items;
    
    public Inventory() {
        this.equippedWeapon = new Weapon("Iron Dagger", 10);
        this.items = new ArrayList();
    }
    
    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    public List<Item> getItems() {
        return this.items;
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
}
