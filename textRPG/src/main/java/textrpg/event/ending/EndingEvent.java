
package textrpg.event.ending;

import java.util.ArrayList;
import textrpg.event.GameEvent;

/**
 * Tapahtuma, joka lopettaa pelin.
 */
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
