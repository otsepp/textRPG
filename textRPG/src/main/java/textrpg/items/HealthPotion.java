
package textrpg.items;

import textrpg.characters.GameCharacter;

/**
 * Elämäpisteitä kasvattava eliksiiri.
 */
public class HealthPotion extends Item implements Usable, UsableOnPlayer {
    private final int healAmount = 70;
    private Inventory inventory;
    
    /**
     * Luo uuden olion.
     * @param inventory Reppu, johon uusi olio kuuluu
     */
    public HealthPotion(Inventory inventory) {
        super("Health Potion");
        this.inventory = inventory;
    }

    
    @Override
    public String use(GameCharacter character) {
        character.addHealth(healAmount);
        return character.getName() + " is healed for " + this.healAmount + " health.";
    }
    
    @Override
    public void removeFromInventory() {
        this.inventory.removeUsableItem(this);
    }
}
