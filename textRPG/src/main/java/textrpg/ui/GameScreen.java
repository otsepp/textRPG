
package textrpg.ui;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
    private GameUIManager uiManager;
    
    public GameScreen(GameUIManager uiManager) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.uiManager = uiManager;
        
        setUpComponents();
    }
    
     private void setUpComponents() {
         
         
         
     }
    
}
