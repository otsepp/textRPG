
package textrpg.event.straightpath;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

/**
 * StraightPathEvent-luokkaan liittyvä komento, jonka jälkeen pelaaja liikkuu eteenpäin. 
 * <p>
 * Huom. voidaan ehkä käyttää myöhemmin.
 * </p>
*/
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
