
package textrpg.events.straight_path_event;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.command.Command;
import textrpg.game_event.GameEventReturnValues;


public class StraightPathEventTest {
    
    private StraightPathEvent event;
    
    public StraightPathEventTest() {
    }
    
    @Before
    public void setUp() {
        this.event = new StraightPathEvent();
    }
    
    
    @Test
    public void startMessageIsCreated() {
        assertEquals("You see a straight path in front of you.", this.event.getStartMessage());
    }

    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.event.getCommands();
        assertEquals(1, commands.size());
        assertEquals(true, commands.get(0) != null);
    }
    
    @Test
    public void commandDescriptionWorks() {
        List<Command> commands = this.event.getCommands();
        assertEquals("Go forward.", commands.get(0).getDescription());
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(1));
    }
    
    @Test
    public void initiateEventWorks() {
        GameEventReturnValues ret = this.event.initiateEvent(0);

        assertEquals(false, ret.getEventContinues());
        
        List<String> messages = ret.getMessages();
        assertEquals(1, messages.size());
        assertEquals("You walk forward.", messages.get(0));
    }
    
}
