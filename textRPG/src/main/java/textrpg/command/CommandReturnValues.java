
package textrpg.command;

import java.util.List;

public class CommandReturnValues {
    
    private List<String> messages;
    private List<Command> newCommands;
    
    public CommandReturnValues(List<String> messages, List<Command> newCommands) {
        this.messages = messages;
        this.newCommands = newCommands;
    }
    
    public List<String> getMessages() {
        return messages;
    }
    
    public List<Command> getNewCommands() {
        return newCommands;
    }
    
}
