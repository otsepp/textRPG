
package textrpg.characters;

import javax.swing.ImageIcon;

public class Bandit extends Enemy{
    
    private final ImageIcon image = new ImageIcon(Bandit.class.getResource("/event_images/bandit.png"));
    
    public Bandit() {
        super("Bandit");
        super.setImage(this.image);
    }
    
}
