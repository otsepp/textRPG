
package textrpg.event;

import java.util.ArrayList;
import java.util.List;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

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
    
    public GameEventReturnValues initiateEvent(int commandId) {
        if (commandId < 0 || commandId > this.commands.size() - 1) {
            return null;
        }
        Command command = this.commands.get(commandId);
        CommandReturnValues returnValues = command.executeCommand();
        
        this.commands = returnValues.getNewCommands();
        
        List<String> returnMessages = new ArrayList();
        returnMessages.addAll(returnValues.getMessages());
        
        boolean eventContinues = true;
        if (this.commands == null) {
            eventContinues = false;
        }
        return new GameEventReturnValues(returnMessages, eventContinues);
    }
    
    protected abstract void fillCommandList();
    
}
