
package textrpg.events.ending_event;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import textrpg.command.Command;
import textrpg.game_event.GameEventReturnValues;
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
    public void startMessageIsCreated() {
        assertEquals(this.endEvent.getStartMessage(), "You have reached the end of the game!");
    }
    
    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.endEvent.getCommands();
        assertEquals(1, commands.size());
        assertEquals(true, commands.get(0) != null);
    }
    
    @Test
    public void commandDescriptionWorks() {
        List<Command> commands = this.endEvent.getCommands();
        assertEquals("Quit game", commands.get(0).getDescription());
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
        assertEquals("Thank you for playing.", messages.get(0));
    }
    
}
