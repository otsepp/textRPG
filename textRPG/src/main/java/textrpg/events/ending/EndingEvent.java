
package textrpg.events.ending;

import java.util.ArrayList;
import textrpg.event.GameEvent;


public class EndingEvent extends GameEvent {
    
    public EndingEvent() {
        super("You have reached the end of the game!",
                new ArrayList());
        setDefaultCommands();
    }
    
    @Override
    protected final  void setDefaultCommands() {
        super.commands.add(new Quit());
    }
        
}
