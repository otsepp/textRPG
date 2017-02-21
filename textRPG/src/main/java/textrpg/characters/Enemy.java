
package textrpg.characters;

import javax.swing.ImageIcon;

/**
 * Kuvaa vihollishahmoa.
 */
public abstract class Enemy extends GameCharacter {
    
    private ImageIcon image;
    private final ImageIcon deathImage = new ImageIcon(Enemy.class.getResource("/event_images/enemy_dead.png"));

    /**
     * Luo vihollisolion.
     * @param name Vihollisen nimi
     */
    public Enemy(String name) {
        super(name);
    }
    
    public Enemy(String name, int maxHealth) {
        super(name, maxHealth);
    }
    
    /**
     * Asettaa hahmoon liittyvän kuvan UI:ta varten.
     * @param image Tavallinen vihollisen kuva
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    
    
    public ImageIcon getImage() {
        return this.image;
    }
    
    public ImageIcon getDeathImage() {
        return this.deathImage;
    }
    
}
