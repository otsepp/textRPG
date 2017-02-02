
package textrpg.command;

import java.util.List;

public abstract class Command {
    protected String description;
    protected String message;
    protected List<Command> newCommands;
    
    public Command(String description, String message, List<Command> newCommands) {
        this.description = description;
        this.message = message;
        this.newCommands = newCommands;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public List<Command> getNewCommands() {
        return this.newCommands;
    }
    
    public abstract CommandReturnValues executeCommand();

}
