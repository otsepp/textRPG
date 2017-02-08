
package textrpg.event.battle;

import java.util.ArrayList;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.Item;
import textrpg.items.Usable;

public class UseItem extends Command {
    private BattleEvent battle;
    private Item item;
    
    public UseItem(BattleEvent battle, Item item, int amount) {
        super(item.getName() + " (" + amount + ")",
                new ArrayList(),
                new ArrayList());
        this.battle = battle;
        this.item = item;
    }
    
    
    @Override
    public CommandReturnValues executeCommand() {
        this.battle.setPlayerTurn(false);
        super.messages.clear();
        
        Usable usable = (Usable) this.item;
        super.messages.add(usable.use(this.battle.getPlayer()));
        usable.removeFromInvetory();
        
        this.battle.setDefaultCommands();
        return new CommandReturnValues(super.messages, battle.getCommands());
    }
    
    
    public BattleEvent getBattleEvent() {
        return this.battle;
    }
    
    public Item getItem() {
        return this.item;
    }
    
}
