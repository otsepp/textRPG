
package textrpg.events.druid;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;
import textrpg.event.druid.ChooseBlessing;

public class ChooseBlessingTest {
    
    private ChooseBlessing command;
    
    public ChooseBlessingTest() {
    }
    
    @Before
    public void setUp() {
        this.command = new ChooseBlessing(new Player("Tester"));
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(false, this.command.getDescription().isEmpty());
        assertEquals(true, this.command.getMessages().isEmpty());
        assertEquals(true, this.command.getNewCommands().isEmpty());
        assertEquals(true, this.command.getPlayer() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        Player player = this.command.getPlayer();
        
        int oldBaseDamage = player.getBaseDamage();
        int oldTotalDamage = player.getTotalDamage();
        
        CommandReturnValues returnValues = this.command.executeCommand();
        
        assertEquals(player.getBaseDamage(), oldBaseDamage + 10);
        assertEquals(player.getTotalDamage(), oldTotalDamage + 10);
        
         assertEquals(true, returnValues.getNewCommands() != null);
        Command newCommand = this.command.getNewCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
    }
    
}
