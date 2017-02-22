
package textrpg.characters;

import javax.swing.ImageIcon;

public class Goblin extends Enemy {
    
    private final ImageIcon image = new ImageIcon(Goblin.class.getResource("/event_images/goblin.png"));

    /**
     * Luo uuden olion. Kenttä baseDamage on 15;
     */
    public Goblin() {
        super("Goblin");
        super.setBaseDamage(15);
        super.setImage(this.image);
    }
    
}
