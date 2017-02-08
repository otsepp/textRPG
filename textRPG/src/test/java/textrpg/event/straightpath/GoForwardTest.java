
package textrpg.event.straightpath;

import textrpg.event.straightpath.GoForward;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.command.CommandReturnValues;


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
        assertEquals(null, this.goForward.getNewCommands());
        assertEquals(true, this.goForward.getMessages().isEmpty());
        assertEquals(true, this.goForward.getDescription() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.goForward.executeCommand();
        assertEquals(null, returnValues.getNewCommands());
    }
    
}
