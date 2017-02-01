
package sudoku.textrpg.characters;

public abstract class Character {
    private String name;
    private int health;
    private int baseDamage;
    
    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.baseDamage = 10;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getBaseDamage() {
        return baseDamage;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
    }
    
}
