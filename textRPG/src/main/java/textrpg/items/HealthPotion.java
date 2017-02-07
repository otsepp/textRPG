
package textrpg.items;

import textrpg.characters.Player;

public class HealthPotion extends Item implements Usable{
    private final int healAmount = 40;
    
    public HealthPotion() {
        super("Health Potion");
    }
    
    @Override
    public String use(Player user) {
        user.addHealth(healAmount);
        return user.getName() + " is healed for " + this.healAmount + " health.";
    }
    
}
