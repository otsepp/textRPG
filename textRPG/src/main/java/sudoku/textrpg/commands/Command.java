
package sudoku.textrpg.commands;

import java.util.List;

public abstract class Command {
    protected String description;
    protected String endMessage;
    protected List<Command> newCommands;
    
    public Command(String description, String endMessage, List<Command> newCommands) {
        this.description = description;
        this.endMessage = endMessage;
        this.newCommands = newCommands;
    }
    
    public String getDescription() {
        return description;
    }
    
     public abstract CommandReturnValues executeCommand();
}
