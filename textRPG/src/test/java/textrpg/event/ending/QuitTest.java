
package textrpg.event.ending;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

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
        assertEquals(true, this.quit.getDescription() != null);
        assertEquals(true, this.quit.getMessages().isEmpty());
        assertEquals(true, this.quit.getNewCommands().isEmpty());
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.quit.executeCommand();
        
        assertEquals(true, returnValues.getNewCommands() != null);

        
        Command newCommand = this.quit.getNewCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
    }
    
}
