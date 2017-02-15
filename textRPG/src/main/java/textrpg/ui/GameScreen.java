
package textrpg.ui;

import java.awt.Dimension;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import textrpg.Game;
import textrpg.command.Command;
import textrpg.event.GameEvent;

public class GameScreen extends JPanel {
    private Game game;

    private GameUIManager uiManager;
    
    private JLabel eventImage;
    private JPanel messagesArea;
    private JPanel commandsArea;
    
    public GameScreen(GameUIManager uiManager) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.game = new Game();
        
        this.uiManager = uiManager;
        
        this.eventImage = createEventImageLabel();
        this.messagesArea = createMessagesArea();
        this.commandsArea = createCommandsArea();
        
        setUpComponents();
    }
    
    
    public void returnToMenu() {
        GameEvent event = this.game.getCurrentEvent();
        
        this.updateEventImage(event.getEventImage());
        this.updateMessagesArea(this.game.getLatestMessages());
        this.updateCommandsArea(event.getCommands());
        this.uiManager.switchToMenuScreen();
    }
    
    public void updateEventImage(ImageIcon newIcon) {
        this.eventImage.setIcon(this.game.getCurrentEvent().getEventImage());
    }
    
    public void updateMessagesArea(List<String> newMessages) {
        this.messagesArea.removeAll();
        
        for (String msg : newMessages) {
            JLabel msgLabel = new JLabel(msg);
            this.messagesArea.add(msgLabel);
        }
        this.messagesArea.revalidate();
        this.messagesArea.repaint();
    }
    
    public void updateCommandsArea(List<Command> commands) {
        this.commandsArea.removeAll();
        
        for (int i = 0; i < commands.size(); i++) {
            Command cmd = commands.get(i);
            
            JButton cmdButton = new JButton(cmd.getDescription());
            cmdButton.addActionListener(new CommandButtonListener(this.game, this, i));
            this.commandsArea.add(cmdButton);
        }
        this.commandsArea.revalidate();
        this.commandsArea.repaint();
    }
     
      private JLabel createEventImageLabel() {
        JLabel label = new JLabel();
        
        ImageIcon icon = this.game.getCurrentEvent().getEventImage();
        label.setIcon(icon);
        
        return label;
    }
     
     private JPanel createMessagesArea() {
        JPanel area  = new JPanel();
        area.setOpaque(false);
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));

        List<String> initialMessages = this.game.getLatestMessages();
        
        for (String msg : initialMessages) {
            JLabel msgLabel = new JLabel(msg);
            area.add(msgLabel);
        }
        
        return area;
    }
    
    private JPanel createCommandsArea() {
        JPanel area = new JPanel();
        area.setOpaque(false);
        
        List<Command> commands = this.game.getCurrentEvent().getCommands();
        
        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);

            JButton cmdButton = new JButton(c.getDescription());
            cmdButton.addActionListener(new CommandButtonListener(this.game, this, i));
            area.add(cmdButton);
        }
        
        return area;
    }
    
     private void setUpComponents() {
         this.eventImage.setAlignmentX(CENTER_ALIGNMENT);
         this.messagesArea.setAlignmentX(CENTER_ALIGNMENT);
         
         this.add(Box.createRigidArea(new Dimension(0, 50)));
         this.add(this.eventImage);
         this.add(Box.createRigidArea(new Dimension(0, 50)));
         this.add(this.messagesArea);
         this.add(Box.createRigidArea(new Dimension(0, 50)));
         this.add(this.commandsArea);
     }
    
}


