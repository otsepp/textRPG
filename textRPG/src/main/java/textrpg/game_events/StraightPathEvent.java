
package textrpg.game_events;

import java.util.ArrayList;
import textrpg.commands.Command;
import textrpg.commands.CommandReturnValues;

public class StraightPathEvent extends GameEvent{
    
    public StraightPathEvent() {
        super("You see a straight path in front of you.",      
                new ArrayList());
        fillCommandList();
    }
    
    @Override
    protected final void fillCommandList() {
       super.commands.add(new GoForward());
    }
    
    
    
    public class GoForward extends Command {
         public GoForward() {
            super("Go forward.",    //description
                    "You walk forward.",    //end message
                    null);  //new commands
        }
        
        @Override
        public CommandReturnValues executeCommand() {
            return new CommandReturnValues(super.endMessage, super.newCommands);
        }
    }
    
}
