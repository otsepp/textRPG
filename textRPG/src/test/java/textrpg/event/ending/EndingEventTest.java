
package textrpg.event.ending;

import textrpg.event.ending.EndingEvent;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import textrpg.command.Command;
import textrpg.event.GameEventReturnValues;
import static org.junit.Assert.assertEquals;

public class EndingEventTest {
    
    private EndingEvent endEvent;
    
    public EndingEventTest() {
    }
    
    @Before
    public void setUp() {
        this.endEvent = new EndingEvent();
    }
    
    
    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.endEvent.getCommands();
        assertEquals(1, commands.size());
        assertEquals(true, commands.get(0) != null);
    }
    
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.endEvent.initiateEvent(-1));
        assertEquals(null, this.endEvent.initiateEvent(1));
    }
    
    @Test
    public void initiateEventWorks() {
        GameEventReturnValues ret = this.endEvent.initiateEvent(0);

        assertEquals(false, ret.getEventContinues());
        
        List<String> messages = ret.getMessages();
        assertEquals(1, messages.size());
    }
    
}
