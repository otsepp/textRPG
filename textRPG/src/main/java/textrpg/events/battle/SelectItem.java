
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.Item;
import textrpg.items.Usable;

public class SelectItem extends Command {
    private BattleEvent battle;
    
    public SelectItem(BattleEvent battle) {
        super("Select an item", //description  
                new ArrayList(),    //messages
                battle.getCommands());   //new commands
        this.battle = battle;
    }

    
    @Override
    public CommandReturnValues executeCommand() {
        battle.setPlayerTurn(true);
        super.messages.clear();
        
        List<Usable> usables = this.battle.getPlayer().getInventory().getUsableItems();
        if (!usables.isEmpty()) {
            setCommands(usables);
        } else {
            super.messages.add("No items to use!");
        }
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
    private void setCommands(List<Usable> usables) {
        for (Usable u : usables) {
            Item uAsItem = (Item) u;
            super.newCommands.clear();
            super.newCommands.add(new UseItem(this.battle, uAsItem));
        }
    }
}
