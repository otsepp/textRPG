
package textrpg.events.straightpath;

import java.util.ArrayList;
import textrpg.event.GameEvent;

public class StraightPathEvent extends GameEvent {
    
    public StraightPathEvent() {
        super("You see a straight path in front of you.",      
                new ArrayList());
        setDefaultCommands();
    }
    
    @Override
    protected final void setDefaultCommands() {
        super.commands.add(new GoForward());
    }
    
}
