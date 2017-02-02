
package textrpg.game_events;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Bandit;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.commands.Command;
import textrpg.commands.CommandReturnValues;

public class BattleEvent extends GameEvent{

    private Player player;
    private Enemy enemy;
    
    public BattleEvent(Player player) {
        super("", new ArrayList());
        this.player = player;
        chooseAnEnemy();
        fillCommandList();
        super.startMessage = "You find yourself facing a " + enemy.getName();
    }
    
    @Override
    protected final void fillCommandList() {
        super.commands.add(new Attack(super.commands, this.player, this.enemy));
    }
    
    @Override
    public GameEventReturnValues initiateEvent(int commandId) {
        GameEventReturnValues ret = super.initiateEvent(commandId);
        
        List<String> messages = ret.getMessages();
        
        if (super.commands != null) {
            messages.add(this.enemy.getName() + " has " + this.enemy.getHealth() + " health remaining.");
            messages.add(attackPlayer());
            
            if (this.player.getHealth() > 0) {
                messages.add(this.player.getName() + " has " + this.player.getHealth() + " health remaining");
            } else {
                messages.add(this.player.getName() + " has died.");
                ret.setEventContinues(false);
            }
            
        } else {
            messages.add(this.enemy.getName() + " is dead. You continue you way.");
        }
        
        return ret;
    }
    
    private String attackPlayer() {
        int damage = this.enemy.getDamage();    //placeholder
        this.player.takeDamage(damage);
        return this.enemy.getName() + " attacks " + this.player.getName() +" for " + damage + " damage.";
    }
    
    private void chooseAnEnemy() {
        this.enemy = new Bandit(); //placeholder
    }
    
    
    
    public class Attack extends Command {
        private List<Command> commands;
        private Player p;
        private Enemy e;
        //nämä kenttinä siltä varalta jos luokka laitetaan omaan tiedostoon (todennäköistä)
        
        public Attack(List<Command> commands, Player p, Enemy e) { 
            super("Attack", 
                    "",
                    commands);
            this.p = p;
            this.e = e;
        }
        
        @Override
        public CommandReturnValues executeCommand() {
            int damage = this.p.getDamage();
            this.e.takeDamage(damage);
            int remainingEnemyHealth = e.getHealth();
            
            String message = this.p.getName() + " attacks " + this.e.getName() + " for " + damage + " damage.";
            
            if (remainingEnemyHealth > 0) {
                return new CommandReturnValues(message, super.newCommands);
            } else {
                return new CommandReturnValues(message, null);
            }
        }
        
        
    }
    
}
