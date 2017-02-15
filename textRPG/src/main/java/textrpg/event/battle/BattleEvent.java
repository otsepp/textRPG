
package textrpg.event.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Continue;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;

/**
 * Yhteenotto vihollisen kanssa.
 */
public class BattleEvent extends GameEvent {

    private Player player;
    private Enemy enemy;
    private boolean playerTurn;
    
    public BattleEvent(Player player, Enemy enemy) {
        super("", new ArrayList());
        this.player = player;
        this.enemy = enemy;
        super.startMessage = "You find yourself facing a " + enemy.getName() + ".";
        this.playerTurn = true;
        setDefaultCommands();
        
        super.setEventImage(this.enemy.getImage());
    }

    
    public boolean isPlayerTurn() {
        return this.playerTurn;
    }

    public void setPlayerTurn(boolean newValue) {
        this.playerTurn = newValue;
    }
    
    @Override
    public final void setDefaultCommands() {
        if (super.commands.size() > 0) {
            super.commands.clear();
        }
        super.commands.add(new Attack(this));
        super.commands.add(new SelectItem(this));
    }
    
    /**
     * Suorittaa pelaajan valitseman komennon indeksin perusteella. Kutsuu ensin yliluokan metodia, jonka palatusarvojen perusteella
     * määritetään, että isketäänkö pelaajaa tai onko vihollinen kuollut.
     * @param commandId pelaajan valitseman komennon indeksi.
     * @return GameEventReturnValues-olio sisältää viestit ja totuusarvon joka ilmaisee, että jatkuuko tapahtuma.
     */
    @Override
    public GameEventReturnValues initiateEvent(int commandId) {
        GameEventReturnValues returnValues = super.initiateEvent(commandId);
        
        if (returnValues == null) {
            return null;
        }
        
        List<String> messages = returnValues.getMessages();
        
        if (super.commands != null && !this.playerTurn) {
            attackPlayer(returnValues);
        } 
        return returnValues;
    }
    
    /**
     * Suoritetaan pelaajan vuoron päättyessä. Muokkaa tapahtumaan liittyvää palautusoliota sen perusteella,
     * että kuoleeko pelaaja iskusta vai ei.
     * @param returnValues Tapahtuman palatusarvo-olio
     */
    private void attackPlayer(GameEventReturnValues returnValues) {
        List<String> messages = returnValues.getMessages();

        int damage = this.enemy.getBaseDamage();
        this.player.takeDamage(damage);
        messages.add(this.enemy.getName() + " attacks " + this.player.getName() + " for " + damage + " damage.");
        
        if (!this.player.isDead()) {
            messages.add(this.player.getName() + " has " + this.player.getHealth() + " health remaining.");
        } else {
            messages.add(this.player.getName() + " has died.");
            
            super.commands.clear();
            super.commands.add(new Continue());
        }
    }
   
    public Player getPlayer() {
        return this.player;
    }
    
    public Enemy getEnemy() {
        return this.enemy;
    }
    
}
