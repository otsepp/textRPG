
package textrpg.command;

import java.util.List;

public abstract class Command {
    protected String description;
    protected List<String> messages;
    protected List<Command> newCommands;
    
    public Command(String description, List<String> messages, List<Command> newCommands) {
        this.description = description;
        this.messages = messages;
        this.newCommands = newCommands;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public List<String> getMessages() {
        return this.messages;
    }
    
    public List<Command> getNewCommands() {
        return this.newCommands;
    }
    
    public abstract CommandReturnValues executeCommand();

}
