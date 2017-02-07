
package textrpg.events.straightpath;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

public class GoForward extends Command {
         
    public GoForward() {
        super("Go forward.",    //description
                new ArrayList(),    //end message
                null);  //new commands
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        super.messages.add("You walk forward.");
        return new CommandReturnValues(super.messages, super.newCommands);
    }
}
