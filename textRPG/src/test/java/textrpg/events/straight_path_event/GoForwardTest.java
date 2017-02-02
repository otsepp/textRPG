
package textrpg.events.straight_path_event;

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
        assertEquals(true, this.goForward.getDescription() != null);
        assertEquals(true, this.goForward.getMessage() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues ret = this.goForward.executeCommand();
        assertEquals(null, ret.getNewCommands());
    }
    
}
