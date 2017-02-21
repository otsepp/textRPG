
package textrpg.items;

import textrpg.characters.GameCharacter;


public class Bomb extends Item implements Usable, UsableOnEnemy{
     private final int damageAmount = 80;
     private Inventory inventory;
    
    public Bomb(Inventory inventory) {
        super("Bomb");
        this.inventory = inventory;
    }
    
    @Override
    public String use(GameCharacter character) {
        character.takeDamage(this.damageAmount);
        return character.getName() + " takes " + damageAmount + " damage from the explosion.";
    }
    
    @Override
    public void removeFromInventory() {
        this.inventory.removeUsableItem(this);
    }
    
}
