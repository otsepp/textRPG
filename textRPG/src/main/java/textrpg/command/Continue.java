
package textrpg.command;

import java.util.ArrayList;

public class Continue extends Command {
    
    public Continue() {
        super("Continue", new ArrayList(), null);
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
}
