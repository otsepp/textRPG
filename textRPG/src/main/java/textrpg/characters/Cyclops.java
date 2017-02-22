
package textrpg.characters;

import javax.swing.ImageIcon;

public class Cyclops extends Enemy {
    
    private final ImageIcon image = new ImageIcon(Cyclops.class.getResource("/event_images/cyclops.png"));
    
    /**
     * Luo Cyclops olion. Kenttä maxHealth asetetaan 140 ja baseDamage 40.
     */
    public Cyclops() {
        super("Cyclops", 140);
        super.setBaseDamage(40);
        super.setImage(this.image);
    }
    
}
