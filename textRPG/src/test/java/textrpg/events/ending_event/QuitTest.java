
package textrpg.events.ending_event;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.command.CommandReturnValues;

public class QuitTest {
    
    private Quit quit;
    
    public QuitTest() {
    }
    
    @Before
    public void setUp() {
        this.quit = new Quit();
    }
    
    @Test
    public void constructorWorks() {
        assertEquals("Quit game", this.quit.getDescription());
        assertEquals("Thank you for playing.", this.quit.getMessage());
        assertEquals(null, this.quit.getNewCommands());
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues ret = this.quit.executeCommand();
        assertEquals("Thank you for playing.", ret.getMessages());
        assertEquals(null, ret.getNewCommands());
    }
    
}
