
package textrpg.events.battle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.CommandReturnValues;
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
    public void executeCommandWorks() {
          CommandReturnValues returnValuesNonEmptyInventory = this.selectItem.executeCommand();
          assertEquals(true, returnValuesNonEmptyInventory.getNewCommands().equals(this.selectItem.getBattleEvent().getCommands()));

          assertEquals(true, this.selectItem.getBattleEvent().isPlayerTurn());
          
          Usable item = this.selectItem.getBattleEvent().getPlayer().getInventory().getUsableItems().get(0);   //health potion
          item.removeFromInvetory();
          CommandReturnValues returnValuesEmptyInventory = this.selectItem.executeCommand(); 
          assertEquals(false, returnValuesNonEmptyInventory.equals(returnValuesEmptyInventory));   
          
          
          assertEquals(true, this.selectItem.getBattleEvent().isPlayerTurn());
    }
    
    
}
