
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.Item;
import textrpg.items.Usable;

public class UseItem extends Command {
    
    private Player player;
    private Usable item;
    
    public UseItem(Player player, Item item, List<Command> commands) {
        super(item.getName(), 
                new ArrayList(),
                commands);
        this.player = player;
        this.item = (Usable) item;
    }
    
    public CommandReturnValues executeCommand() {
        
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
}
