
package textrpg.event.straightpath;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.command.Command;
import textrpg.command.Continue;
import textrpg.event.GameEventReturnValues;


public class StraightPathEventTest {
    
    private StraightPathEvent event;
    
    public StraightPathEventTest() {
    }
    
    @Before
    public void setUp() {
        this.event = new StraightPathEvent();
    }
    

    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.event.getCommands();
        assertEquals(1, commands.size());
        assertEquals(true, commands.get(0) != null);
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(1));
    }
    
    @Test
    public void initiateEventWorks() {
        GameEventReturnValues ret = this.event.initiateEvent(0);

        assertEquals(true, ret.getEventContinues());
        
        Command newCommand = this.event.getCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
        
        List<String> messages = ret.getMessages();
        assertEquals(1, messages.size());
    }
    
}
