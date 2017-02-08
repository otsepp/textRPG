
package textrpg.event.ending;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

/**
 * Ending-event-luokkaan liittyvä komento, jonka suorituksen jälkeen peli lopetetaan.
 */
public class Quit extends Command {
    public Quit() {
        super("Quit game", 
                new ArrayList(),   
                null);  
    }

    @Override
    public CommandReturnValues executeCommand() {
        super.messages.add("Thank you for playing.");
        return new CommandReturnValues(super.messages, super.newCommands);
    }
}
