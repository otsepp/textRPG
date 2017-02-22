
package textrpg.event.druid;

import java.util.ArrayList;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

/**
 * Komento kasvattaa pelaajan baseDamage-kentän arvoa 10:llä.
 */
public class ChooseBlessing extends Command {
    
    private Player player;
    
    /**
     * Luo uuden olion. 
     * @param player Tapahtumaan liittyvä pelaaja
     */
    public ChooseBlessing(Player player) {
        super("Choose blessing", 
                new ArrayList(),
                new ArrayList());
        this.player = player;
    }
    
    @Override
    public CommandReturnValues executeCommand() {
        int damage = this.player.getBaseDamage();
        damage += 10;
        this.player.setBaseDamage(damage);
        this.player.updateDamage();
        
        super.messages.add(("Base damage of "  + this.player.getName() + " has increased by 10."));
        super.newCommands.add(new Continue());
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
}
