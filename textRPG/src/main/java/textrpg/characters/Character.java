
package textrpg.characters;

public abstract class Character {
    private String name;
    private int maxHealth;
    private int health;
    private int baseDamage;
    
    public Character(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = this.maxHealth;
        this.baseDamage = 10;
    }
    
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
    
    public void takeDamage(int damageDone) {
        this.health -= damageDone;
    }
    
    public void addHealth(int healthToAdd) {
        if (this.health + healthToAdd > this.maxHealth) {
            this.health = maxHealth;
        }
    }
    
}
