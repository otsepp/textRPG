
package textrpg.events.druid;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.Continue;
import textrpg.event.GameEventReturnValues;
import textrpg.event.druid.DruidEncounterEvent;

public class DruidEncounterEventTest {
    
    public DruidEncounterEventTest() {
    }
    private DruidEncounterEvent event;
    
    @Before
    public void setUp() {
        Player player = new Player("Tester");
        event = new DruidEncounterEvent(player);
    }
    
    @Test
    public void playerIsNotNull() {
        assertEquals(true, this.event.getPlayer() != null);
    }
    
    
    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.event.getCommands();
        assertEquals(2, commands.size());
        for (Command c : commands) {
            assertEquals(true, c != null);
        }
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(2));
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
