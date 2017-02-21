
package textrpg.event.straightpath;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

/**
 * StraightPathEvent-luokkaan liittyvä komento, jonka jälkeen pelaaja liikkuu eteenpäin. 
*/
public class GoForward extends Command {
    
    /**
     * Luo uuden olion.
     */
    public GoForward() {
        super("Go forward",    
                new ArrayList(),    
                new ArrayList()); 
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        super.messages.add("You walk forward.");
        super.newCommands.add(new Continue());
        return new CommandReturnValues(super.messages, super.newCommands);
    }
}
