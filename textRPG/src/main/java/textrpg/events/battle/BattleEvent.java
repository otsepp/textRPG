
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;

public class BattleEvent extends GameEvent {

    private Player player;
    private Enemy enemy;
    private boolean playerTurn;
    
    private List<Command> defaultCommands;
    
    public BattleEvent(Player player, Enemy enemy) {
        super("", new ArrayList());
        this.player = player;
        this.enemy = enemy;
        super.startMessage = "You find yourself facing a " + enemy.getName();
        this.playerTurn = true;
        setDefaultCommands();
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
    
    @Override
    public GameEventReturnValues initiateEvent(int commandId) {
        GameEventReturnValues returnValues = super.initiateEvent(commandId);
        
        if (returnValues == null) {
            return null;
        }
        
        List<String> messages = returnValues.getMessages();
        
        if (super.commands != null && !this.playerTurn) {
             attackPlayer(returnValues);
        } else if (super.commands == null) {
            messages.add(this.enemy.getName() + " is dead. You continue your way.");
        }
        return returnValues;
    }
    
    private void attackPlayer( GameEventReturnValues returnValues) {
        List<String> messages = returnValues.getMessages();

        int damage = this.enemy.getBaseDamage();
        this.player.takeDamage(damage);
        messages.add(this.enemy.getName() + " attacks " + this.player.getName() + " for " + damage + " damage.");
        
        if (this.player.getHealth() > 0) {
            messages.add(this.player.getName() + " has " + this.player.getHealth() + " health remaining");
        } else {
            messages.add(this.player.getName() + " has died.");
            super.commands = null;
            returnValues.setEventContinues(false);
        }
    }
   
    public Player getPlayer() {
        return this.player;
    }
    
    public Enemy getEnemy() {
        return this.enemy;
    }
    
}
