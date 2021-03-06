
package textrpg.event.battle;

import java.util.ArrayList;
import java.util.Map;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.Item;
import textrpg.items.Usable;

/**
 * Komento, jolla pelaaja voi valita käytettävän tavaran.
 */
public class SelectItem extends Command {
    private BattleEvent battle;
    
    /**
     * Luo uuden olion.
     * @param battle Yhteenottotapahtuma, jossa komento suoritetaan
     */
    public SelectItem(BattleEvent battle) {
        super("Select an item", //description  
                new ArrayList(),    //messages
                battle.getCommands());   //new commands
        this.battle = battle;
    }

    /**
     * Suorittaa komennon. Jos pelaajalla on käytettäviä tavaroita, metodi palauttaa UseItem-komentoja näiden perusteella. Muuten
     * komennot pysyvät samana. Komento ei lopeta pelaajan vuoroa.
     * @return CommandReturnValues-olio sisältää komenttiin liittyvät viestit ja uudet komennot. 
     */
    @Override
    public CommandReturnValues executeCommand() {
        battle.setPlayerTurn(true);
        super.messages.clear();
        
        Map<Usable, Integer> usables = this.battle.getPlayer().getInventory().getUsableItems();
        if (!usables.isEmpty()) {
            setCommands(usables);
        } else {
            super.messages.add("No items to use!");
        }
        return new CommandReturnValues(super.messages, super.newCommands);
    }
    
    private void setCommands(Map<Usable, Integer> usables) {
        super.newCommands.clear();
        for (Usable u : usables.keySet()) {
            Item uAsItem = (Item) u;
            super.newCommands.add(new UseItem(this.battle, uAsItem, usables.get(u)));
        }
    }
    
    public BattleEvent getBattleEvent() {
        return this.battle;
    }
}
