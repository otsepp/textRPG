
package textrpg.characters;

import javax.swing.ImageIcon;

/**
 * Kuvaa vihollishahmoa.
 */
public class Enemy extends Character {
    
    private ImageIcon image;
    private ImageIcon deathImage;

    /**
     * Luo vihollisolion.
     * @param name Vihollisen nimi
     */
    public Enemy(String name) {
        super(name);
    }
    
    /**
     * Asettaa hahmoon liittyvät kuvat UI:ta varten.
     * @param image Tavallinen vihollisen kuva
     * @param deathImage Vihollisen kuva tämän kuoleman jälkeen
     */
    public void setImages(ImageIcon image, ImageIcon deathImage) {
        this.image = image;
        this.deathImage = deathImage;
    }
    
    public ImageIcon getImage() {
        return this.image;
    }
    
    public ImageIcon getDeathImage() {
        return this.deathImage;
    }
    
}
