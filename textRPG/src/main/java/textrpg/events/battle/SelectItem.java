
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

public class SelectItem extends Command {
    private Player player;
    
    public SelectItem(Player player,BattleEvent battle) {
        super("Use an item", 
                new ArrayList(),
                new ArrayList());
        this.player = player; 
    }
    
    public CommandReturnValues executeCommand() {
        
        
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
    private void createCommands() {
        
    }
    
}
