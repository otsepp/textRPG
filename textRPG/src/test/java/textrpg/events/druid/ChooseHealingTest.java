
package textrpg.events.druid;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;
import textrpg.event.druid.ChooseHealing;


public class ChooseHealingTest {
    private ChooseHealing command;
    
    public ChooseHealingTest() {
    }
    
    @Before
    public void setUp() {
        this.command = new ChooseHealing(new Player("Tester"));
    }

     @Test
     public void constructorWorks() {
         assertEquals(false, this.command.getDescription().isEmpty());
         assertEquals(true, this.command.getMessages() != null && this.command.getMessages().isEmpty());
         assertEquals(true, this.command.getNewCommands() != null && this.command.getNewCommands().isEmpty());
         assertEquals(true, this.command.getPlayer() != null);
    }
     
     @Test
     public void executeCommandWorks() {
         Player player = this.command.getPlayer();
         player.takeDamage(80);
         int oldHealth = player.getHealth();
         CommandReturnValues returnValues = this.command.executeCommand();
         assertEquals(player.getHealth(), oldHealth + 50);
         assertEquals(false, returnValues.getMessages().isEmpty());
         assertEquals(true, returnValues.getNewCommands() != null);
         Command newCommand = this.command.getNewCommands().get(0);
         assertEquals(true, newCommand instanceof Continue);
     }
    
}
