
package textrpg.event.straightpath;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;


public class GoForwardTest {

    private GoForward event;
    
    public GoForwardTest() {
    }
    
    @Before
    public void setUp() {
        this.event = new GoForward();
    }
    
     @Test
    public void constructorWorks() {
        assertEquals(true, this.event.getDescription() != null);
        assertEquals(true, this.event.getMessages().isEmpty());
        assertEquals(true, this.event.getNewCommands().isEmpty());
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.event.executeCommand();
      
        assertEquals(true, returnValues.getNewCommands() != null);
        
        Command newCommand = this.event.getNewCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
        
    }
    
}
