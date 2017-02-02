
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.event.GameEvent;
import textrpg.event.GameEventReturnValues;

public class BattleEvent extends GameEvent {

    private Player player;
    private Enemy enemy;
    
    public BattleEvent(Player player, Enemy enemy) {
        super("", new ArrayList());
        this.player = player;
        this.enemy = enemy;
        super.startMessage = "You find yourself facing a " + enemy.getName();
        fillCommandList();

    }
    
    @Override
    protected final void fillCommandList() {
        super.commands.add(new Attack(super.commands, this.player, this.enemy));
    }
    
    @Override
    public GameEventReturnValues initiateEvent(int commandId) {
        GameEventReturnValues ret = super.initiateEvent(commandId);
        
        if (ret == null) {
            return null;
        }
        
        List<String> messages = ret.getMessages();
        
        if (super.commands != null) {
            messages.add(this.enemy.getName() + " has " + this.enemy.getHealth() + " health remaining.");
            messages.add(attackPlayer());
            
            if (this.player.getHealth() > 0) {
                messages.add(this.player.getName() + " has " + this.player.getHealth() + " health remaining");
            } else {
                messages.add(this.player.getName() + " has died.");
                super.commands = null;
                ret.setEventContinues(false);
            }
            
        } else {
            messages.add(this.enemy.getName() + " is dead. You continue your way.");
        }
        
        return ret;
    }
    
    private String attackPlayer() {
        int damage = this.enemy.getBaseDamage();
        this.player.takeDamage(damage);
        return this.enemy.getName() + " attacks " + this.player.getName() + " for " + damage + " damage.";
    }
   
    public Player getPlayer() {
        return this.player;
    }
    
    public Enemy getEnemy() {
        return this.enemy;
    }
    
}
