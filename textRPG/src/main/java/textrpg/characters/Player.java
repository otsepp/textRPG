
package textrpg.characters;

import textrpg.items.Inventory;

public class Player extends Character {
    
    private Inventory inventory;
    
    public Player(String name) {
        super(name);
        super.setHealth(150);
        this.inventory = new Inventory();
        this.updateDamage();
    }
    
    public void updateDamage() {
        int oldDamage = super.getDamage();
        int equippedWeaponDamage = this.inventory.getEquippedWeapon().getDamage();
        super.setDamage(oldDamage + equippedWeaponDamage);
    }
    
}
