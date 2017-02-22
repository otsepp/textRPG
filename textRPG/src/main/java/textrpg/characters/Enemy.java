
package textrpg.characters;

import javax.swing.ImageIcon;

/**
 * Abstrakti luokka, joka uvaa vihollishahmoa.
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
    
    /**
     * Luo vihollisolion annetulla nimellä ja hp-määrällä.
     * @param name Olion nimi
     * @param maxHealth Olion max elämäpisteet
     */
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
