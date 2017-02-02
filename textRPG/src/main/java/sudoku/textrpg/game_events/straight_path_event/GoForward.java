
package sudoku.textrpg.game_events.straight_path_event;

import sudoku.textrpg.commands.Command;
import sudoku.textrpg.commands.CommandReturnValues;

public class GoForward extends Command{
    public GoForward() {
            super("Go forward.",    //description
                    "You walk forward.",    //end message
                    null);  //new commands
        }
        
        @Override
        public CommandReturnValues executeCommand() {
            return new CommandReturnValues(this.endMessage, this.newCommands);
        }
}
