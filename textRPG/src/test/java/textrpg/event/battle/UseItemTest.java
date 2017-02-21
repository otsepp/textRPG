
package textrpg.event.battle;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Bandit;
import textrpg.characters.Player;
import textrpg.items.HealthPotion;
import textrpg.items.Inventory;
import textrpg.items.Item;
import textrpg.items.Usable;

public class UseItemTest {
    
    private UseItem useItem;
    
    public UseItemTest() {
    }
    
    @Before
    public void setUp() {
        BattleEvent battle = new BattleEvent(new Player("Tester"), new Bandit());
        
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
    public void playerLosesTurn() {
        BattleEvent battle = this.useItem.getBattleEvent();
        this.useItem.executeCommand();
        assertEquals(false, battle.isPlayerTurn());
    }
    
    @Test
    public void executeCommandWorks() {
        Usable itemAsUsable = (Usable) this.useItem.getItem();
        Inventory inventory = this.useItem.getBattleEvent().getPlayer().getInventory();

        inventory.removeAllUsableItems();
        inventory.addUsableItem(itemAsUsable);
        
       int itemCount = inventory.getUsableItems().get(itemAsUsable);    
       assertEquals(1, itemCount);
       
       this.useItem.executeCommand();
       
       assertEquals(true, inventory.getUsableItems().get(itemAsUsable) == null);
    
       
    }
    
}
