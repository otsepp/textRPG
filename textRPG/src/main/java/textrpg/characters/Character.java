
package textrpg.characters;

public abstract class Character {
    private String name;
    private int health;
    private int damage;
    
    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 10;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public void takeDamage(int damageDone) {
        this.health -= damageDone;
    }
    
}
