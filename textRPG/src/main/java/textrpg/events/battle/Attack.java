
package textrpg.events.battle;

import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;


public class Attack extends Command {
    private Player player;
    private Enemy enemy;
    
    public Attack(List<Command> commands, Player player, Enemy enemy) {
        super("Attack",
                "",
                commands);
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public CommandReturnValues executeCommand() {
        int damage = this.player.getTotalDamage();
        this.enemy.takeDamage(damage);
        int remainingEnemyHealth = enemy.getHealth();
        
        String message = this.player.getName() + " attacks " + this.enemy.getName() + " for " + damage + " damage.";
        
        if (remainingEnemyHealth > 0) {
            return new CommandReturnValues(message, super.newCommands);
        } else {
            return new CommandReturnValues(message, null);
        }
    }
    
    public Player getPlayer() {
        return this.player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

}
