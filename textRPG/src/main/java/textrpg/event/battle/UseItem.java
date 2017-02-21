
package textrpg.event.battle;

import java.util.ArrayList;
import textrpg.characters.GameCharacter;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.items.Item;
import textrpg.items.Usable;
import textrpg.items.UsableOnPlayer;

/**
 * Komento, jolla pelaaja käyttää valitun tavaran.
 * @author Glarthir
 */
public class UseItem extends Command {
    private BattleEvent battle;
    private Item item;
    
    /**
     * Luo uuden olion.
     * @param battle Yhteenottotapahtuma, jossa komento suoritetaan
     * @param item Käytettävä tavara
     * @param amount Tavaran lukumäärä pelaajan repussa
     */
    public UseItem(BattleEvent battle, Item item, int amount) {
        super(item.getName() + " (" + amount + ")",
                new ArrayList(),
                new ArrayList());
        this.battle = battle;
        this.item = item;
    }
    
    /**
     * Komento suoritetaan. Kun tavara on käytetty, se poistetaan pelaajan repusta.
     * @return CommandReturnValues-olio sisältää komenttiin liittyvät viestit ja uudet komennot. Uudet komennot ovat 
     * BattleEvent-tapahtuman oletuskomennot.
     */
    @Override
    public CommandReturnValues executeCommand() {
        this.battle.setPlayerTurn(false);
        super.messages.clear();

        Usable usable = (Usable) this.item;
        
        GameCharacter character;
        
        if (usable instanceof UsableOnPlayer) {
            character = this.battle.getPlayer();
            super.messages.add(usable.use(character));
        } else {
            character = this.battle.getEnemy();
            super.messages.add(usable.use(character));
        }
        usable.removeFromInventory();
        
        super.messages.add(character.getName() + " now has " + character.getHealth() + " health.");
        
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
