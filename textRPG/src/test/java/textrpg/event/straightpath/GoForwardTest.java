
package textrpg.event.straightpath;

import static org.junit.Assert.assertEquals;
import textrpg.event.straightpath.GoForward;
import org.junit.Before;
import org.junit.Test;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;


public class GoForwardTest {

    private GoForward goForward;
    
    public GoForwardTest() {
    }
    
    @Before
    public void setUp() {
        this.goForward = new GoForward();
    }
    
     @Test
    public void constructorWorks() {
        assertEquals(true, this.goForward.getDescription() != null);
        assertEquals(true, this.goForward.getMessages().isEmpty());
        assertEquals(true, this.goForward.getNewCommands().isEmpty());
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.goForward.executeCommand();
      
        assertEquals(true, returnValues.getNewCommands() != null);
        
        Command newCommand = this.goForward.getNewCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
        
    }
    
}
