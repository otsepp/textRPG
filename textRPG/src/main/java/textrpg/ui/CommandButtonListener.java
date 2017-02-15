
package textrpg.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import textrpg.GameInterpreter;
import textrpg.GameInterpreter.GameStatus;
import textrpg.event.GameEvent;

public class CommandButtonListener  implements ActionListener {
        private GameInterpreter gameInterpreter;
        private GameScreen gameScreen;
        private int commandId;
        
        public CommandButtonListener(GameInterpreter gameInterpreter, GameScreen gameScreen, int commandId) {
            this.gameInterpreter  = gameInterpreter;
            this.gameScreen = gameScreen;
            this.commandId = commandId;
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        GameStatus result = this.gameInterpreter.executeCommand(commandId);
        
        GameEvent event = this.gameInterpreter.getCurrentEvent();
        
        this.gameScreen.updateEventImage(event.getEventImage());
        this.gameScreen.updateMessagesArea(this.gameInterpreter.getLatestMessages());
        this.gameScreen.updateCommandsArea(event.getCommands());       
        
        if (result == GameStatus.GAME_END)  {
            this.gameScreen.returnToMenu();
        }
    }
    
}