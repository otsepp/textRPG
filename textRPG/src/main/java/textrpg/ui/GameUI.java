
package textrpg.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class GameUI{
    
    private JFrame frame;
    private MenuScreen menu;
    
    public GameUI() {
        this.frame = createFrame();
        this.menu = new MenuScreen();
    }
    
    
    public void start() {
        this.frame.getContentPane().add(this.menu);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    
    
    
    private JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        return frame;
    }
    
}
