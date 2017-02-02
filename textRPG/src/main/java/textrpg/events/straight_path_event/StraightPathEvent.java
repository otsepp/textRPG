
package textrpg.events.straight_path_event;

import java.util.ArrayList;
import textrpg.game_event.GameEvent;

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
    
}
