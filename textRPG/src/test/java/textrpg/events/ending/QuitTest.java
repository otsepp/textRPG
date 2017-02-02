
package textrpg.events.ending;

import textrpg.events.ending.Quit;
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
        assertEquals(null, this.quit.getNewCommands());
        assertEquals(true, this.quit.getDescription() != null);
        assertEquals(true, this.quit.getMessage() != null);

    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues ret = this.quit.executeCommand();
        assertEquals(null, ret.getNewCommands());
    }
    
}
