
package textrpg.items;

/**
 * Kuvaa asetta, jolla on nimi ja tietty määrä vahinkoa, jota se aiheuttaa.
 */
public class Weapon extends Item {
    
    private int damage;
    
    /**
     * Luo uuden ase-olion.
     * @param name Aseen nimi
     * @param damage Aseen aiheuttama vahinko
     */
    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
}
