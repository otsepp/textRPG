
package textrpg.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class GameUIManager {
    
    private JFrame frame;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    
    private JLayeredPane layeredPane;
    
    public GameUIManager() {
        this.frame = createFrame();
        this.menuScreen = new MenuScreen(this);
        this.gameScreen = new GameScreen(this);
    }
    
    
    public void createAndShowGUI() {
        this.frame.getContentPane().add(this.menuScreen);
        
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
    
    private JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        return frame;
    }
    
    public void switchToGameScreen() {
        this.frame.getContentPane().add(this.gameScreen);
        
        this.menuScreen.setVisible(true);
        this.frame.getContentPane().remove(this.menuScreen);
    }
    
    public void switchToMenuScreen() {
        this.frame.getContentPane().add(this.menuScreen);
        
        this.gameScreen.setVisible(true);
        this.frame.getContentPane().remove(this.gameScreen);
    }
    
}