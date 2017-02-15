
package textrpg.characters;

import javax.swing.ImageIcon;

public class Enemy extends Character {
    
    private ImageIcon image;
    private ImageIcon deathImage;
    
    public Enemy(String name) {
        super(name);
    }
    
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
