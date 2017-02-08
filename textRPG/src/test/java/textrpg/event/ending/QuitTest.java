
package textrpg.event.ending;

import textrpg.event.ending.Quit;
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
        assertEquals(true, this.quit.getMessages().isEmpty());
        assertEquals(true, this.quit.getDescription() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.quit.executeCommand();
        assertEquals(null, returnValues.getNewCommands());
    }
    
}
