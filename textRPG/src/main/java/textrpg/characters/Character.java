
package textrpg.characters;


public abstract class Character {
    private String name;
    private int maxHealth;
    private int health;
    private int baseDamage;
    
    /**
     * Oliolle annetaan oletusarvoiset attribuutit.
     * @param name Hahmolle annettava nimi
     */
    public Character(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = this.maxHealth;
        this.baseDamage = 10;
    }
    
    /**
     * Olion elämäpisteiden maksimiarvoksi annetaan annettu määrä.
     * @param name  Hahmolle annettava nimi.
     * @param maxHealth Hahmon maksimielämäpisteet.
     */
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = this.maxHealth;
        this.baseDamage = 10;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getBaseDamage() {
        return this.baseDamage;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    
    public boolean isDead() {
        if (this.health > 0) {
            return false;
        }
        return true;
    }
    
    public void takeDamage(int damageDone) {
        this.health -= damageDone;
    }
    
    /**
     * Lisää elämäpisteisiin annettu määrä. Ei ylitä pelaajan maksimielämäpisteitä.
     * @param healthToAdd lisättävä määrä.
     */
    public void addHealth(int healthToAdd) {
        if (this.health + healthToAdd > this.maxHealth) {
            this.health = maxHealth;
        }
    }
    
}
