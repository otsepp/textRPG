
package sudoku.textrpg.commands;

public class CommandReturnValues {
    
    private String message;
    private Command[] newCommands;
    
    public CommandReturnValues(String message, Command[] newCommands) {
        this.message = message;
        this.newCommands = newCommands;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Command[] getCommands() {
        return newCommands;
    }
    
}
