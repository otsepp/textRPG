
package textrpg.events.ending;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;


public class Quit extends Command {
    public Quit() {
        super("Quit game", 
                new ArrayList(),   
                null);  
    }

    @Override
    public CommandReturnValues executeCommand() {
        super.messages.add("You walk forward.");
        return new CommandReturnValues(super.messages, super.newCommands);
    }
}
