
package sudoku.textrpg.commands;

import java.util.List;

public class CommandReturnValues {
    
    private String endMessage;
    private List<Command> newCommands;
    
    public CommandReturnValues(String endMessage, List<Command> newCommands) {
        this.endMessage = endMessage;
        this.newCommands = newCommands;
    }
    
    public String getMessage() {
        return endMessage;
    }
    
    public List<Command> getCommands() {
        return newCommands;
    }
    
}