
package textrpg.commands;

import java.util.List;

public class CommandReturnValues {
    
    private String message;
    private List<Command> newCommands;
    
    public CommandReturnValues(String message, List<Command> newCommands) {
        this.message = message;
        this.newCommands = newCommands;
    }
    
    public String getMessages() {
        return message;
    }
    
    public List<Command> getNewCommands() {
        return newCommands;
    }
    
}
