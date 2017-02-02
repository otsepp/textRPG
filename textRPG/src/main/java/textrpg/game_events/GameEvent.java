
package textrpg.game_events;

import java.util.List;
import textrpg.commands.Command;
import textrpg.commands.CommandReturnValues;

public abstract class GameEvent {
    protected String startMessage;
    protected List<Command> commands;
    
    public GameEvent(String startMessage, List<Command> commands) {
        this.startMessage = startMessage;
        this.commands = commands;
    }
    
    public String getStartMessage() {
        return this.startMessage;
    }
    
    public List<Command> getCommands() {
        return this.commands;
    }
    
    public GameEventReturnValues execCommand(int commandId) {
         if (commandId < 0 || commandId > this.commands.size() - 1) {
            return null;
        }
        Command command = this.commands.get(commandId);
        CommandReturnValues ret = command.executeCommand();
        
        this.commands = ret.getNewCommands();
        String endMessage = ret.getEndMessage();
        
        boolean eventContinues = true;
        if (this.commands == null) {
            eventContinues = false;
        }
        return new GameEventReturnValues(endMessage, eventContinues);
    }
    
    protected abstract void fillCommandList();
    
}
