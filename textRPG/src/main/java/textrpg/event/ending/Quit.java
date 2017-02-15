
package textrpg.event.ending;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

/**
 * Ending-event-luokkaan liittyvä komento.
 */
public class Quit extends Command {
    
    /**
     * Luo uuden olion.
     */
    public Quit() {
        super("Quit game", 
                new ArrayList(),   
                new ArrayList());
    }

    @Override
    public CommandReturnValues executeCommand() {
        super.messages.add("Thank you for playing.");
        super.newCommands.add(new Continue());
        return new CommandReturnValues(super.messages, super.newCommands);
    }
}
