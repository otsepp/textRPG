
package textrpg.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Näyttää aloitusruudun.
 */
public class MenuScreen extends JPanel {
    private GameUIManager uiManager;
    
    private JLabel logo;
    private JButton startButton;
    
    public MenuScreen(GameUIManager uiManager) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.uiManager = uiManager;
        
        this.logo = createLogoLabel();
        this.startButton = createStartButton();
        
        setUpComponents();
    }
    
    
    private void setUpComponents() {
        this.logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(this.logo);
        this.add(Box.createRigidArea(new Dimension(0, 220)));
        this.add(this.startButton);
    }
    
    private JLabel createLogoLabel() {
        JLabel logo = new JLabel("textRPG");
        
        Font font = new Font("High Tower Text", Font.PLAIN, 45);
        logo.setFont(font);
        return logo;
    }
    
    private JButton createStartButton() {
        JButton startButton = new JButton("Begin");
        
        startButton.addActionListener(e -> {
            this.uiManager.switchToGameScreen();
        });
        
        return startButton;
    }
}
