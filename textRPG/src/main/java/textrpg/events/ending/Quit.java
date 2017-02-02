
package textrpg.events.ending;

import textrpg.command.Command;
import textrpg.command.CommandReturnValues;


public class Quit extends Command {
    public Quit() {
        super("Quit game",  //description
                "Thank you for playing.",   //endmessage
                null);  //new commands
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        return new CommandReturnValues(super.message, super.newCommands);
    }
}
