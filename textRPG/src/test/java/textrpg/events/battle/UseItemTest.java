
package textrpg.events.battle;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.CommandReturnValues;
import textrpg.items.Inventory;
import textrpg.items.Item;
import textrpg.items.Usable;

public class UseItemTest {
    
    private UseItem useItem;
    
    public UseItemTest() {
    }
    
    @Before
    public void setUp() {
        BattleEvent battle = new BattleEvent(new Player("Tester"), new Enemy("Tester's enemy"));
        
        Usable usable = battle.getPlayer().getInventory().getUsableItems().get(0);   //health potion

        Item item = (Item) usable;
        
        this.useItem = new UseItem(battle, item);
    }
    
    
    @Test
    public void constructorWorks() {
        assertEquals(true, this.useItem.getBattleEvent() != null);
        assertEquals(true, this.useItem.getBattleEvent().getPlayer() != null);
        assertEquals(true, this.useItem.getItem() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        CommandReturnValues returnValues = this.useItem.executeCommand();
        
        Inventory inventory = this.useItem.getBattleEvent().getPlayer().getInventory();
        
        assertEquals(0, inventory.getUsableItems().size());
        
        assertEquals(false, this.useItem.getBattleEvent().isPlayerTurn());
    }
    
}
