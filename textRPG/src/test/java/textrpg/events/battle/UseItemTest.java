
package textrpg.events.battle;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.CommandReturnValues;
import textrpg.items.HealthPotion;
import textrpg.items.Inventory;
import textrpg.items.Item;

public class UseItemTest {
    
    private UseItem useItem;
    
    public UseItemTest() {
    }
    
    @Before
    public void setUp() {
        BattleEvent battle = new BattleEvent(new Player("Tester"), new Enemy("Tester's enemy"));
        
        Inventory inventory = battle.getPlayer().getInventory();
        Item item = new HealthPotion(inventory);
        int amount = inventory.getUsableItems().get(item);
        
        this.useItem = new UseItem(battle, item, amount);
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
        assertEquals(1, inventory.getUsableItems().size());
        
        assertEquals(false, this.useItem.getBattleEvent().isPlayerTurn());
    }
    
}
