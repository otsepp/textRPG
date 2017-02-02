
package textrpg.game_events;

import java.util.ArrayList;
import textrpg.commands.Command;
import textrpg.commands.CommandReturnValues;


public class EndEvent extends GameEvent{
    
        public EndEvent() {
            super("You have reached the end of the game!", 
                    new ArrayList());
            fillCommandList();
        }

        @Override
        protected final void fillCommandList() {
            super.commands.add(new Quit());
        }
        
        
        
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
        
}
