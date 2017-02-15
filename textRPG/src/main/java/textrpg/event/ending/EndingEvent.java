
package textrpg.event.ending;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import textrpg.main.Game;
import textrpg.event.GameEvent;

/**
 * Tapahtuma, joka lopettaa pelin.
 */
public class EndingEvent extends GameEvent {
    
    public EndingEvent() {
        super("You have reached the end of the game!",
                new ArrayList());
        setDefaultCommands();
        super.setEventImage( new ImageIcon(EndingEvent.class.getResource("/event_images/ending.png")));
    }
    
    @Override
    protected final  void setDefaultCommands() {
        super.commands.add(new Quit());
    }
        
}
