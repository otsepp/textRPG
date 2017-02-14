
package textrpg.ui;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    private GameUIManager uiManager;
    
    public GameScreen(GameUIManager uiManager) {
        this.setOpaque(false);
        
        this.uiManager = uiManager;
        
        setUpComponents();
    }
    
     private void setUpComponents() {
       
     }
    
}
