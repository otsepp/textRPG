
package textrpg.events.battle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
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
    public void executeCommandWorks() {
        BattleEvent battleEvent = this.selectItem.getBattleEvent();
        
          CommandReturnValues returnValuesNonEmptyInventory = this.selectItem.executeCommand();
          assertEquals(true, returnValuesNonEmptyInventory.getNewCommands().equals(battleEvent.getCommands()));

          assertEquals(true, battleEvent.isPlayerTurn());
          
          Usable item = new HealthPotion(battleEvent.getPlayer().getInventory());   
          item.removeFromInvetory();
          CommandReturnValues returnValuesEmptyInventory = this.selectItem.executeCommand(); 
          assertEquals(false, returnValuesNonEmptyInventory.equals(returnValuesEmptyInventory));   
          
          assertEquals(true, battleEvent.isPlayerTurn());
    }
    
    
}
