
package textrpg.characters;

import textrpg.items.Inventory;

public class Player extends GameCharacter {
    
    private Inventory inventory;
    private int totalDamage;
    
    /**
     * Luo pelaajaolion.
     * @param name Pelaajan nimi
     */
    public Player(String name) {
        super(name, 150);
        this.inventory = new Inventory();
        this.updateDamage();
    }
    
    
    public int getTotalDamage() {
        return this.totalDamage;
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }
    
    /**
     * Summaa pelaajan baseDamage:n ja tällä hetkellä käytössä olevan aseen vahinkopisteet.
     */
    public void updateDamage() {
        int weaponDamage = this.inventory.getEquippedWeapon().getDamage();
        this.totalDamage = super.getBaseDamage() + weaponDamage;
    }
    
}
