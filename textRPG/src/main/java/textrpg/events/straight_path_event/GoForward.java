
package textrpg.events.straight_path_event;

import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

public class GoForward extends Command {
         
    public GoForward() {
        super("Go forward.",    //description
                "You walk forward.",    //end message
                null);  //new commands
        }
         
         @Override
        public CommandReturnValues executeCommand() {
            return new CommandReturnValues(super.message, super.newCommands);
        }
}
