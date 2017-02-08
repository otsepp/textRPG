
package textrpg.events.battle;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.HealthPotion;
import textrpg.items.Usable;

public class SelectItemTest {
    
    private SelectItem selectItem;
    
    public SelectItemTest() {
    }
    
    @Before
    public void setUp() {
        BattleEvent battleEvent = new BattleEvent(new Player("Tester"), new Enemy("Tester's enemy"));
        this.selectItem = new SelectItem(battleEvent);
    }
    
    
    @Test
    public void constructorWorks() {
        BattleEvent battle = this.selectItem.getBattleEvent();
        assertEquals(true, battle != null);
        assertEquals(true, battle.getPlayer() != null);
        assertEquals(true, battle.getEnemy() != null);
        assertEquals(true, battle.getCommands() != null);
    }
    
    @Test
    public void playerKeepsTurn() {
        BattleEvent battleEvent = this.selectItem.getBattleEvent();

        this.selectItem.executeCommand();
        assertEquals(true, battleEvent.isPlayerTurn());
    }
    
    @Test
    public void commandsAreNotChangedWhenNoItemsToUse() {
        BattleEvent battleEvent = this.selectItem.getBattleEvent();
        
        Player player = battleEvent.getPlayer();
        player.getInventory().removeAllUsableItems();
        
        CommandReturnValues returnValues = this.selectItem.executeCommand();
        
        List<Command> commands = returnValues.getNewCommands();
        for (Command c : commands) {
            assertEquals(false, c instanceof UseItem);
        }
    }
    
    @Test
    public void commandsAreChangedWhenUsableItemsExist() {
        BattleEvent battleEvent = this.selectItem.getBattleEvent();
        
        CommandReturnValues returnValues = this.selectItem.executeCommand();
        List<Command> commands = returnValues.getNewCommands();
        for (Command c : commands) {
            assertEquals(true, c instanceof UseItem);
        }
    }
    
    
}
