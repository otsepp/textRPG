
package textrpg.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Hallitsee eri ruutuja (menu ja peli).
 */
public class GameUIManager {
    private JFrame frame;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    
    private JLayeredPane layeredPane;
    
    /**
     * Luo uuden olion. Luo JFrame-olion ja menu-ja peliruutuja kuvaat oliot, jotka periytyvät luokasta JPanel.
     */
    public GameUIManager() {
        this.frame = createFrame();
        this.menuScreen = new MenuScreen(this);
        this.gameScreen = new GameScreen(this);
    }
    
    
    /**
     * Aloittaa pelin.
     */
    public void start() {
        this.frame.getContentPane().add(this.menuScreen);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
    
    /**
     * Vaihtaa menuruudusta peliruutuun.
     */
    public void switchToGameScreen() {
        this.menuScreen.setVisible(false);
        this.frame.getContentPane().remove(this.menuScreen);
        
        this.frame.getContentPane().add(this.gameScreen);
        this.gameScreen.setVisible(true);
    }
    
    /**
     * Vaihtaa peliruudusta menuruutuun.
     */
    public void switchToMenuScreen() {
        this.gameScreen.setVisible(false);
        this.frame.getContentPane().remove(this.gameScreen);
        
        this.frame.getContentPane().add(this.menuScreen);
        this.menuScreen.setVisible(true);
    }
    
    private JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        return frame;
    }
}
