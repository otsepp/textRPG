
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
        assertEquals("Go forward.", this.goForward.getDescription());
        assertEquals("You walk forward.", this.goForward.getMessage());
        assertEquals(null, this.goForward.getNewCommands());
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues ret = this.goForward.executeCommand();
        assertEquals("You walk forward.", ret.getMessages());
        assertEquals(null, ret.getNewCommands());
    }
    
}
