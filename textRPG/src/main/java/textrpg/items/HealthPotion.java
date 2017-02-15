
package textrpg.items;

import textrpg.characters.Player;

/**
 * Elämäpisteitä kasvattava eliksiiri.
 */
public class HealthPotion extends Item implements Usable {
    private final int healAmount = 40;
    private Inventory inventory;
    
    public HealthPotion(Inventory inventory) {
        super("Health Potion");
        this.inventory = inventory;
    }

    
    @Override
    public String use(Player user) {
        user.addHealth(healAmount);
        return user.getName() + " is healed for " + this.healAmount + " health.";
    }
    
    @Override
    public void removeFromInvetory() {
        this.inventory.removeUsableItem(this);
    }
}
