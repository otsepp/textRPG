
package textrpg.events.ending_event;

import java.util.ArrayList;
import textrpg.game_event.GameEvent;


public class EndingEvent extends GameEvent{
    
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
