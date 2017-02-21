
package textrpg.event.druid;

import java.util.ArrayList;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;


public class ChooseHealing extends Command {
    private Player player;
    
    public ChooseHealing(Player player) {
        super("Choose healing", new ArrayList(), new ArrayList());
        this.player = player;
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        this.player.addHealth(50);
        super.messages.add(this.player.getName() + " has been healed for 50 points.");
        super.messages.add(this.player.getName() + " now has " + this.player.getHealth() + " health.");

        super.newCommands.add(new Continue());

        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
}
