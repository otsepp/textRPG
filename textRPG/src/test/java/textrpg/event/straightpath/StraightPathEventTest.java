
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
        assertEquals(false, commands.isEmpty());
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        int outOfBoundsIndex = event.getCommands().size();
        assertEquals(null, this.event.initiateEvent(outOfBoundsIndex));
    }
    
    @Test
    public void initiateEventWorks() {
        GameEventReturnValues ret = this.event.initiateEvent(0);

        assertEquals(true, ret.getEventContinues());
        
        Command newCommand = this.event.getCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
        
        List<String> messages = ret.getMessages();
        assertEquals(false, messages.isEmpty());
    }
    
}
