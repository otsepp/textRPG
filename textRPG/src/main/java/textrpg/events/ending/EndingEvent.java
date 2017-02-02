
package textrpg.events.ending;

import java.util.ArrayList;
import textrpg.event.GameEvent;


public class EndingEvent extends GameEvent {
    
    public EndingEvent() {
        super("You have reached the end of the game!",
                new ArrayList());
        fillCommandList();
    }
    
    @Override
    protected final void fillCommandList() {
        super.commands.add(new Quit());
    }
        
}
