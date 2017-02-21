
package textrpg.characters;

import javax.swing.ImageIcon;

public class Goblin extends Enemy {
    
    private final ImageIcon image = new ImageIcon(Goblin.class.getResource("/event_images/goblin.png"));

    
    public Goblin() {
        super("Goblin");
        super.setBaseDamage(15);
        super.setImage(image);
    }
    
}
